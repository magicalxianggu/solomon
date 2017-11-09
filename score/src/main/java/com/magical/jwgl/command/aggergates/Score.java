package com.magical.jwgl.command.aggergates;

import com.magical.cloud.commands.CreateScoreCommand;
import com.magical.cloud.commands.RecordScoreCommand;
import com.magical.cloud.domain.*;
import com.magical.cloud.events.ScoreCreatedEvent;
import com.magical.cloud.events.ScoreRecordedEvent;
import com.magical.jwgl.command.domain.HundredMark;
import com.magical.jwgl.command.domain.Mark;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/**
 * 成绩
 * Created by zhouxp on 2017/11/9
 */
@Aggregate
public class Score {

    @AggregateIdentifier
    private ScoreID scoreID;

    //教学班成绩登记ID
    private TeachingClassScoreRecordID teachingClassScoreRecordID;

    private StudentID studentID;

    private CourseID courseID;

    private String termID;

    //总成绩
    private Float totalScore;

    //成绩
    private HashMap<ScoreTypeEnum,Mark> allScore = new HashMap<>();

    public Score() {
    }

    @CommandHandler
    public Score(CreateScoreCommand command) {
        apply(new ScoreCreatedEvent(command.getScoreID(),command.getTeachingClassScoreRecordID(),command.getStudentID(),command.getCourseID(),command.getTermID(),command.getScores()));

    }

    @CommandHandler
    public void on(RecordScoreCommand command){
        apply(new ScoreRecordedEvent(command.getScoreID(),command.getScores()));
    }

    @EventHandler
    public void handler(ScoreCreatedEvent event)  throws Exception {

        this.scoreID = event.getScoreID();
        this.courseID = event.getCourseID();
        this.studentID = event.getStudentID();
        this.teachingClassScoreRecordID = event.getTeachingClassScoreRecordID();
        this.termID = event.getTermID();

        Iterator<Map.Entry<ScoreTypeEnum, String>> it = event.getScores().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<ScoreTypeEnum, String> entry = it.next();
            //根据成绩类型判断该类型成绩使用的分制
            HundredMark mark = new HundredMark(Float.parseFloat(entry.getValue()));
            this.allScore.put(entry.getKey(), mark);
        }

        //计算总成绩
        this.calculateTotalScore();
    }

    @EventHandler
    public void handler(ScoreRecordedEvent event) throws Exception{

        Iterator<Map.Entry<ScoreTypeEnum, String>> it = event.getScores().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<ScoreTypeEnum, String> entry = it.next();
            //根据成绩类型判断该类型成绩使用的分制
            HundredMark mark = new HundredMark(Float.parseFloat(entry.getValue()));
            this.allScore.put(entry.getKey(), mark);
        }

        //计算总成绩
        this.calculateTotalScore();

    }
    /**
     * 计算总成绩
     */
    private void calculateTotalScore(){

        //根据教学班成绩登记ID获取课程考核标准

        //如果所有成绩分项已经全部有成绩则计算总成绩

    }
}
