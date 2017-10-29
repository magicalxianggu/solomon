package com.magical.jwgl.command.aggergates;

import com.magical.cloud.domain.CourseEvaluateStandardID;
import com.magical.cloud.domain.TeachingClassID;
import com.magical.cloud.domain.EvaluateCourse;
import com.magical.jwgl.command.domain.ScoreReportCard;
import com.magical.cloud.domain.ScoreTypeEnum;
import com.magical.cloud.domain.TeachingClassScoreID;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateMember;
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

    //课程考核标准
    private CourseEvaluateStandardID courseEvaluateStandardID;

    //各分项成绩登记表
    @AggregateMember
    private HashMap<ScoreTypeEnum,ScoreReportCard> scoreReportCards=new HashMap<ScoreTypeEnum,ScoreReportCard>();

}

