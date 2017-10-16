package com.magical.cloud.domain;

public class TeachingCourse {

    private String teachingCourseID;
    private String courseName;
    //课程类型：考试、考察
    private String courseType;
    //课程性质：必修、选修
    private String courseNature;

    public TeachingCourse(String teachingCourseID, String courseName, String courseType, String courseNature) {
        this.teachingCourseID = teachingCourseID;
        this.courseName = courseName;
        this.courseType = courseType;
        this.courseNature = courseNature;
    }

    public String getTeachingCourseID() {
        return teachingCourseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public String getCourseNature() {
        return courseNature;
    }


}
