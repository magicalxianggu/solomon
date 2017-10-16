package com.magical.cloud.domain;

public class CourseStudent
{
    private String courseStudentID;
    private String studentName;

    public CourseStudent(String courseStudentID, String studentName) {
        this.courseStudentID = courseStudentID;
        this.studentName = studentName;
    }

    public String getCourseStudentID() {
        return courseStudentID;
    }

    public String getStudentName() {
        return studentName;
    }
}
