package com.magical.cloud.events;


import com.magical.cloud.domain.CourseStudent;
import com.magical.cloud.domain.CourseTeacher;
import com.magical.cloud.domain.TeachingClassID;
import com.magical.cloud.domain.TeachingCourse;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateMember;

import java.util.ArrayList;

public class TeachingClassCreatedEvent {

    @TargetAggregateIdentifier
    private TeachingClassID teachingClassID;
    private TeachingCourse teachingCourse;

    //学时时间段（学期）
    private String studingInterval;
    @AggregateMember
    private ArrayList<CourseTeacher> courseTeachers;
    @AggregateMember
    private ArrayList<CourseStudent> courseStudents;

    public TeachingClassCreatedEvent(TeachingClassID teachingClassID, TeachingCourse teachingCourse, String studingInterval, ArrayList<CourseTeacher> courseTeachers, ArrayList<CourseStudent> courseStudents) {
        this.teachingClassID = teachingClassID;
        this.teachingCourse = teachingCourse;
        this.studingInterval = studingInterval;
        this.courseTeachers = courseTeachers;
        this.courseStudents = courseStudents;
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
