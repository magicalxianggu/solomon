package com.magical.cloud.commands;

import com.magical.cloud.domain.TeacherPositionEnum;
import com.magical.cloud.domain.TeachingClassID;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.ArrayList;
import java.util.Map;

public class CreateTeachingClassCommand {


    @TargetAggregateIdentifier
    private TeachingClassID teachingClassID;

    //上课教员信息。k:"courseID",v:教员ID；k:"courseType",v:课程类型；k:"courseNature",V:课程性质
    private Map<String,String>  courseInfo;

    //学时时间段（学期）
    private String studingInterval;

    //k:教员ID；v:上课教员类型
    private Map<String,TeacherPositionEnum> teachers;

    private ArrayList<String> studentIDs;

    public CreateTeachingClassCommand(Map<String,String> courseInfo, String studingInterval, Map<String, TeacherPositionEnum> teachers, ArrayList<String> studentIDs) {
        this.teachingClassID = new TeachingClassID();
        this.courseInfo = courseInfo;
        this.studingInterval = studingInterval;
        this.teachers = teachers;
        this.studentIDs = studentIDs;
    }

    public TeachingClassID getTeachingClassID() {
        return teachingClassID;
    }

    public Map<String, String> getCourseInfo() {
        return courseInfo;
    }

    public String getStudingInterval() {
        return studingInterval;
    }

    public Map<String, TeacherPositionEnum> getTeachers() {
        return teachers;
    }

    public ArrayList<String> getStudentIDs() {
        return studentIDs;
    }
}
