package com.magical.cloud.commands;

import com.magical.cloud.domain.*;

import java.util.HashMap;

/**
 * Created by zhouxp on 2017/11/9
 */
public class CreateScoreCommand {

    private ScoreID scoreID;

    private TeachingClassScoreRecordID teachingClassScoreRecordID;

    private StudentID studentID;

    private CourseID courseID;

    private String termID;

    private HashMap<ScoreTypeEnum,String>  scores = new HashMap<>();

    public CreateScoreCommand(ScoreID scoreID, TeachingClassScoreRecordID teachingClassScoreRecordID, StudentID studentID, CourseID courseID,  String termID,HashMap<ScoreTypeEnum, String> scores) {
        this.scoreID = scoreID;
        this.teachingClassScoreRecordID = teachingClassScoreRecordID;
        this.studentID = studentID;
        this.courseID = courseID;
        this.scores = scores;

        this.termID = termID;
    }

    public ScoreID getScoreID() {
        return scoreID;
    }

    public TeachingClassScoreRecordID getTeachingClassScoreRecordID() {
        return teachingClassScoreRecordID;
    }

    public StudentID getStudentID() {
        return studentID;
    }

    public CourseID getCourseID() {
        return courseID;
    }

    public HashMap<ScoreTypeEnum, String> getScores() {
        return scores;
    }

    public String getTermID() {
        return termID;
    }
}
