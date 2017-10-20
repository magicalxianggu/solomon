package com.magical.jwgl.aggregates;


import com.magical.cloud.domain.CourseStudent;
import com.magical.cloud.domain.CourseTeacher;
import com.magical.cloud.domain.TeachingClassID;
import com.magical.cloud.domain.TeachingCourse;
import com.magical.cloud.events.TeachingClassCreatedEvent;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateMember;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.ArrayList;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class TeachingClass {

    @AggregateIdentifier
    private TeachingClassID teachingClassID;

    @AggregateMember
    private TeachingCourse teachingCourse;

    //学时时间段（学期）
    private String studingInterval;
    @AggregateMember
    private ArrayList<CourseTeacher> courseTeachers;
    @AggregateMember
    private ArrayList<CourseStudent> courseStudents;

    public TeachingClass() {
    }



    public TeachingClass(TeachingClassID teachingClassID, TeachingCourse teachingCourse, String studingInterval, ArrayList<CourseTeacher> courseTeachers, ArrayList<CourseStudent> courseStudents) {

        apply(new TeachingClassCreatedEvent(teachingClassID,teachingCourse,studingInterval,courseTeachers,courseStudents));
    }

    @EventHandler
    public void on(TeachingClassCreatedEvent teachingClassCreatedEvent){
        this.teachingClassID = teachingClassCreatedEvent.getTeachingClassID();
        this.teachingCourse = teachingClassCreatedEvent.getTeachingCourse();
        this.studingInterval = teachingClassCreatedEvent.getStudingInterval();
        this.courseTeachers = teachingClassCreatedEvent.getCourseTeachers();
        this.courseStudents = teachingClassCreatedEvent.getCourseStudents();

    }

    public TeachingClassID getTeachingClassID() {
        return teachingClassID;
    }

    public TeachingCourse getTeachingCourse() {
        return teachingCourse;
    }

    public String getStudingInterval() {
        return studingInterval;
    }

    public ArrayList<CourseTeacher> getCourseTeachers() {
        return courseTeachers;
    }

    public ArrayList<CourseStudent> getCourseStudents() {
        return courseStudents;
    }
}
