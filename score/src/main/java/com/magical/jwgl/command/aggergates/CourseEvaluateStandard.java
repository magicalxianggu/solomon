package com.magical.jwgl.command.aggergates;

import com.magical.cloud.commands.CreateCourseEvaluateStandardCommand;
import com.magical.cloud.domain.CheckTypeEnum;
import com.magical.cloud.domain.CourseEvaluateStandardID;
import com.magical.cloud.events.CourseEvaluateStandardCreatedEvent;
import com.magical.jwgl.command.domain.EvaluateCourse;
import com.magical.cloud.domain.ScoreTypeEnum;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/**
 * 课程考核标准
 * Created by zhouxp on 2017/10/23
 */
@Aggregate
public class CourseEvaluateStandard {

    @AggregateIdentifier
    private CourseEvaluateStandardID courseEvaluateStandardID;
    //考核课程ID
    private String  courseID;

    //版本号（此处对应学期ID）
    private String version;

    //考核方式
    private CheckTypeEnum checkType;

    //考核成绩类型
    private Set<ScoreTypeEnum> requireMarkTypes=new HashSet();

    //各考核成绩权重
    private HashMap<ScoreTypeEnum,Float> everyMarkWeighting=new HashMap();

    public CourseEvaluateStandard() {
    }

    @CommandHandler
    public CourseEvaluateStandard(CreateCourseEvaluateStandardCommand command) {
       apply(new CourseEvaluateStandardCreatedEvent(command.getCourseEvaluateStandardID(),command.getCourseID(),command.getVersion(),command.getCheckType(),command.getEveryMarkWeighting()));
    }

    @EventHandler
    public void on(CourseEvaluateStandardCreatedEvent event){
        this.courseEvaluateStandardID = event.getCourseEvaluateStandardID();
        this.courseID = event.getCourseID();
        this.checkType = event.getCheckType();
        this.everyMarkWeighting = event.getEveryMarkWeighting();
        this.requireMarkTypes = event.getEveryMarkWeighting().keySet();
    }
}
