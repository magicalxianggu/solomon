package com.magical.jwgl.entries;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TeachingCourseEntry {

   @Id
    private String teachingCourseID;
    private String courseName;
    //课程类型：考试、考察
    private String courseType;
    //课程性质：必修、选修
    private String courseNature;

    public TeachingCourseEntry(String teachingCourseID, String courseName, String courseType, String courseNature) {
        this.teachingCourseID = teachingCourseID;
        this.courseName = courseName;
        this.courseType = courseType;
        this.courseNature = courseNature;
    }

    public String getTeachingCourseID() {
        return teachingCourseID;
    }

    public void setTeachingCourseID(String teachingCourseID) {
        this.teachingCourseID = teachingCourseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseNature() {
        return courseNature;
    }

    public void setCourseNature(String courseNature) {
        this.courseNature = courseNature;
    }
}
