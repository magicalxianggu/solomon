package com.magical.jwgl.command.aggergates;

import com.magical.cloud.domain.CourseEvaluateStandardID;
import com.magical.cloud.domain.EvaluateCourse;
import com.magical.cloud.domain.TeachingClassID;
import com.magical.cloud.domain.TeachingClassScoreRecordID;
import com.magical.cloud.events.TeachingClassScoreCreatedEvent;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/**
 * 教学班成绩
 * Created by zhouxp on 2017/10/23
 */
@Aggregate
public class TeachingClassScoreRecord {


    @AggregateIdentifier
    private TeachingClassScoreRecordID teachingClassScoreRecordID;

    //教学班ID
    private TeachingClassID teachingClassID;

    //考核时间
    private String termID;

    //考核课程
    private EvaluateCourse evaluateCourse;

    //课程考核标准
    private CourseEvaluateStandardID courseEvaluateStandardID;


    public TeachingClassScoreRecord() {
    }

    public TeachingClassScoreRecord(TeachingClassScoreRecordID teachingClassScoreID, TeachingClassID teachingClassID, String termID, EvaluateCourse evaluateCourse, CourseEvaluateStandardID courseEvaluateStandardID) {
     apply(new TeachingClassScoreCreatedEvent(teachingClassScoreID,teachingClassID,termID,evaluateCourse,courseEvaluateStandardID));
    }

    @EventHandler
    public void on(TeachingClassScoreCreatedEvent event){
        this.courseEvaluateStandardID =event.getCourseEvaluateStandardID();
        this.evaluateCourse = event.getEvaluateCourse();
        this.teachingClassID = event.getTeachingClassID();
        this.termID = event.getTermID();
        this.teachingClassScoreRecordID = event.getTeachingClassScoreID();

    }
    public TeachingClassScoreRecordID getTeachingClassScoreID() {
        return teachingClassScoreRecordID;
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


}

