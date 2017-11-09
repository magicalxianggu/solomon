package com.magical.cloud.commands;

import com.magical.cloud.domain.*;

import java.util.HashMap;

/**
 * 登记成绩
 * Created by zhouxp on 2017/11/9
 */
public class RecordScoreCommand {

    private ScoreID scoreID;

    private HashMap<ScoreTypeEnum,String>  scores = new HashMap<>();

    public RecordScoreCommand(ScoreID scoreID, HashMap<ScoreTypeEnum, String> scores) {
        this.scoreID = scoreID;
        this.scores = scores;
    }

    public ScoreID getScoreID() {
        return scoreID;
    }

    public HashMap<ScoreTypeEnum, String> getScores() {
        return scores;
    }
}
