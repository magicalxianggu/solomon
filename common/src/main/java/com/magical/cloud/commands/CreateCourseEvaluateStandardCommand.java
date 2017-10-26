package com.magical.cloud.commands;

import com.magical.cloud.domain.CheckTypeEnum;
import com.magical.cloud.domain.ScoreTypeEnum;
import com.magical.cloud.domain.TeachingClassID;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhouxp on 2017/10/26
 */
public class CreateCourseEvaluateStandardCommand {

    private TeachingClassID teachingClassID;

    private String courseID;

    //考核时间
    private String termID;

    //考核方式
    private CheckTypeEnum checkType;

    //考核成绩类型
    private Set<ScoreTypeEnum> requireMarkTypes=new HashSet();

    //各考核成绩权重
    private HashMap<ScoreTypeEnum,Float> everyMarkWeighting=new HashMap();


    public CreateCourseEvaluateStandardCommand(TeachingClassID teachingClassID, String courseID, String termID, CheckTypeEnum checkType, Set<ScoreTypeEnum> requireMarkTypes, HashMap<ScoreTypeEnum, Float> everyMarkWeighting) {
        this.teachingClassID = teachingClassID;
        this.courseID = courseID;
        this.termID = termID;
        this.checkType = checkType;
        this.requireMarkTypes = requireMarkTypes;
        this.everyMarkWeighting = everyMarkWeighting;
    }

    public TeachingClassID getTeachingClassID() {
        return teachingClassID;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getTermID() {
        return termID;
    }

    public CheckTypeEnum getCheckType() {
        return checkType;
    }

    public Set<ScoreTypeEnum> getRequireMarkTypes() {
        return requireMarkTypes;
    }

    public HashMap<ScoreTypeEnum, Float> getEveryMarkWeighting() {
        return everyMarkWeighting;
    }
}
