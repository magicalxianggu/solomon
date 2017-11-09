package com.magical.cloud.events;

import com.magical.cloud.domain.*;

import java.util.HashMap;

/**
 * Created by zhouxp on 2017/11/9
 */
public class ScoreRecordedEvent {

    private ScoreID scoreID;

    private HashMap<ScoreTypeEnum,String>  scores = new HashMap<>();

    public ScoreRecordedEvent(ScoreID scoreID, HashMap<ScoreTypeEnum, String> scores) {
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
