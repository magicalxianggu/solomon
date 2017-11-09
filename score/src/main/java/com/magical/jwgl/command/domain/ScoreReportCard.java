package com.magical.jwgl.command.domain;

import com.magical.cloud.domain.StudentID;

import java.util.HashMap;

/**
 * 成绩登记卡
 * Created by zhouxp on 2017/10/23
 */
public class ScoreReportCard {

    private HashMap<StudentID,Mark> scores;

    public ScoreReportCard(HashMap<StudentID, Mark> scores) {
        this.scores = scores;
    }

    public HashMap<StudentID, Mark> getScores() {
        return scores;
    }
}
