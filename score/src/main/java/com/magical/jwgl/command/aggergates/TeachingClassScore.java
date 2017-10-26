package com.magical.jwgl.command.aggergates;

import com.magical.cloud.domain.TeachingClassID;
import com.magical.jwgl.command.domain.EvaluateCourse;
import com.magical.jwgl.command.domain.ScoreReportCard;
import com.magical.cloud.domain.ScoreTypeEnum;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.HashMap;

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

    //各分项成绩登记表
    private HashMap<ScoreTypeEnum,ScoreReportCard> scoreReportCards=new HashMap<ScoreTypeEnum,ScoreReportCard>();

}

