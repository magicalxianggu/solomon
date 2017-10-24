package com.magical.jwgl.entries;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class TeachingClassEntry {

    @Id
    private String teachingClassID;

    //学时时间段（学期）
    private String studingInterval;

    private TeachingCourseEntry teachingCourse;

    private List<CourseStudentEntry> courseStudentList;

    private List<CourseTeacherEntry> courseTeacherList;

    public String getTeachingClassID() {
        return teachingClassID;
    }

    public TeachingClassEntry(String teachingClassID, String studingInterval, TeachingCourseEntry teachingCourse, List<CourseStudentEntry> courseStudentList, List<CourseTeacherEntry> courseTeacherList) {
        this.teachingClassID = teachingClassID;
        this.studingInterval = studingInterval;
        this.teachingCourse = teachingCourse;
        this.courseStudentList = courseStudentList;
        this.courseTeacherList = courseTeacherList;
    }

    public void setTeachingClassID(String teachingClassID) {
        this.teachingClassID = teachingClassID;
    }

    public String getStudingInterval() {
        return studingInterval;
    }

    public void setStudingInterval(String studingInterval) {
        this.studingInterval = studingInterval;
    }

    public TeachingCourseEntry getTeachingCourse() {
        return teachingCourse;
    }

    public void setTeachingCourse(TeachingCourseEntry teachingCourse) {
        this.teachingCourse = teachingCourse;
    }

    public List<CourseStudentEntry> getCourseStudentList() {
        return courseStudentList;
    }

    public void setCourseStudentList(List<CourseStudentEntry> courseStudentList) {
        this.courseStudentList = courseStudentList;
    }

    public List<CourseTeacherEntry> getCourseTeacherList() {
        return courseTeacherList;
    }

    public void setCourseTeacherList(List<CourseTeacherEntry> courseTeacherList) {
        this.courseTeacherList = courseTeacherList;
    }
}
