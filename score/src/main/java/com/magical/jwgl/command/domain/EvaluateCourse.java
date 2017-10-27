package com.magical.jwgl.command.domain;

/**
 * 考核课程
 * Created by zhouxp on 2017/10/23
 */
public class EvaluateCourse {

    private String courseID;

    private String courseName;

    private String courseNO;

    public EvaluateCourse(String courseID, String courseName, String courseNO) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseNO = courseNO;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseNO() {
        return courseNO;
    }
}

