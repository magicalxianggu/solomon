package com.magical.jwgl.entries;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CourseStudentEntry {
    @Id
    private String courseStudentID;
    private String studentName;

    public String getCourseStudentID() {
        return courseStudentID;
    }

    public CourseStudentEntry(String courseStudentID, String studentName) {
        this.courseStudentID = courseStudentID;
        this.studentName = studentName;
    }

    public void setCourseStudentID(String courseStudentID) {
        this.courseStudentID = courseStudentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
