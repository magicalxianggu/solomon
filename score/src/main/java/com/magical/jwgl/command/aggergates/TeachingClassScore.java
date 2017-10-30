package com.magical.jwgl.command.aggergates;

import com.magical.cloud.domain.CourseEvaluateStandardID;
import com.magical.cloud.domain.TeachingClassID;
import com.magical.cloud.domain.EvaluateCourse;
import com.magical.cloud.events.TeachingClassScoreCreatedEvent;
import com.magical.jwgl.command.domain.ScoreReportCard;
import com.magical.cloud.domain.ScoreTypeEnum;
import com.magical.cloud.domain.TeachingClassScoreID;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateMember;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.HashMap;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/**
 * 教学班成绩
 * Created by zhouxp on 2017/10/23
 */
@Aggregate
public class TeachingClassScore {


    @AggregateIdentifier
    private TeachingClassScoreID teachingClassScoreID;

    //教学班ID
    private TeachingClassID teachingClassID;

    //考核时间
    private String termID;

    //考核课程
    private EvaluateCourse evaluateCourse;

    //课程考核标准
    private CourseEvaluateStandardID courseEvaluateStandardID;

    //各分项成绩登记表
    @AggregateMember
    private HashMap<ScoreTypeEnum,ScoreReportCard> scoreReportCards=new HashMap<ScoreTypeEnum,ScoreReportCard>();


    public TeachingClassScore() {
    }

    public TeachingClassScore(TeachingClassScoreID teachingClassScoreID, TeachingClassID teachingClassID, String termID, EvaluateCourse evaluateCourse, CourseEvaluateStandardID courseEvaluateStandardID) {
     apply(new TeachingClassScoreCreatedEvent(teachingClassScoreID,teachingClassID,termID,evaluateCourse,courseEvaluateStandardID));
    }

    @EventHandler
    public void on(TeachingClassScoreCreatedEvent event){
        this.courseEvaluateStandardID =event.getCourseEvaluateStandardID();
        this.evaluateCourse = event.getEvaluateCourse();
        this.teachingClassID = event.getTeachingClassID();
        this.termID = event.getTermID();
        this.teachingClassScoreID = event.getTeachingClassScoreID();

    }
    public TeachingClassScoreID getTeachingClassScoreID() {
        return teachingClassScoreID;
    }

    public TeachingClassID getTeachingClassID() {
        return teachingClassID;
    }

    public String getTermID() {
        return termID;
    }

    public EvaluateCourse getEvaluateCourse() {
        return evaluateCourse;
    }

    public CourseEvaluateStandardID getCourseEvaluateStandardID() {
        return courseEvaluateStandardID;
    }

    public HashMap<ScoreTypeEnum, ScoreReportCard> getScoreReportCards() {
        return scoreReportCards;
    }
}

