package com.magical.cloud.domain;

public class CourseTeacher {
    private String courseTeacherID;
    private String courseTeacherName;
    //上课教员类型
    private TeacherPositionEnum teacherPosition;

    public CourseTeacher(String courseTeacherID, String courseTeacherName, TeacherPositionEnum teacherPosition) {
        this.courseTeacherID = courseTeacherID;
        this.courseTeacherName = courseTeacherName;
        this.teacherPosition = teacherPosition;
    }

    public String getCourseTeacherID() {
        return courseTeacherID;
    }

    public String getCourseTeacherName() {
        return courseTeacherName;
    }

    public TeacherPositionEnum getTeacherPosition() {
        return teacherPosition;
    }

}
