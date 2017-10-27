package com.magical.cloud.events;

import com.magical.cloud.domain.CheckTypeEnum;
import com.magical.cloud.domain.CourseEvaluateStandardID;
import com.magical.cloud.domain.ScoreTypeEnum;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.HashMap;

/**
 * Created by zhouxp on 2017/10/27
 */
public class CourseEvaluateStandardCreatedEvent {

    @TargetAggregateIdentifier
    private CourseEvaluateStandardID courseEvaluateStandardID;

    private String courseID;

    //版本号
    private String version;

    //考核方式
    private CheckTypeEnum checkType;

    //各考核成绩权重
    private HashMap<ScoreTypeEnum,Float> everyMarkWeighting=new HashMap();

    public CourseEvaluateStandardCreatedEvent(CourseEvaluateStandardID courseEvaluateStandardID, String courseID, String version, CheckTypeEnum checkType, HashMap<ScoreTypeEnum, Float> everyMarkWeighting) {
        this.courseEvaluateStandardID = courseEvaluateStandardID;
        this.courseID = courseID;
        this.version = version;
        this.checkType = checkType;
        this.everyMarkWeighting = everyMarkWeighting;
    }

    public CourseEvaluateStandardID getCourseEvaluateStandardID() {
        return courseEvaluateStandardID;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getVersion() {
        return version;
    }

    public CheckTypeEnum getCheckType() {
        return checkType;
    }

    public HashMap<ScoreTypeEnum, Float> getEveryMarkWeighting() {
        return everyMarkWeighting;
    }
}
