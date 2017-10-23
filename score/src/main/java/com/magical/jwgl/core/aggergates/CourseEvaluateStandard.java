package com.magical.jwgl.core.aggergates;

import com.magical.jwgl.core.domain.CheckTypeEnum;
import com.magical.jwgl.core.domain.EvaluateCourse;
import com.magical.jwgl.core.domain.ScoreTypeEnum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhouxp on 2017/10/23
 */
public class CourseEvaluateStandard {

    //课程
    private EvaluateCourse course;
    private String termID;//暂时不实现，先留着
    //考核方式
    private CheckTypeEnum checkType;

    //考试要求
    private Set<ScoreTypeEnum> requireMarkTypes=new HashSet();
    private HashMap<ScoreTypeEnum,Float> everyMarkWeighting=new HashMap();
}
