package com.magical.jwgl.command.aggergates;

import com.magical.cloud.domain.CheckTypeEnum;
import com.magical.jwgl.command.domain.EvaluateCourse;
import com.magical.cloud.domain.ScoreTypeEnum;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 课程考核标准
 * Created by zhouxp on 2017/10/23
 */
@Aggregate
public class CourseEvaluateStandard {

    //考核课程
    @AggregateIdentifier
    private EvaluateCourse course;

    //版本号（此处对应学期ID）
    @AggregateIdentifier
    private String version;

    //考核方式
    private CheckTypeEnum checkType;

    //考核成绩类型
    private Set<ScoreTypeEnum> requireMarkTypes=new HashSet();

    //各考核成绩权重
    private HashMap<ScoreTypeEnum,Float> everyMarkWeighting=new HashMap();

    public CourseEvaluateStandard() {
    }
}
