package com.magical.jwgl.query.entries;


import org.springframework.data.annotation.Id;

/**
 * Created by zhouxp on 2017/10/20
 */

public class StudentEntry {

    @Id
    private String studentID;
    private String studentName;
    private String classID;

    public StudentEntry(String studentID, String studentName, String classID) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.classID = classID;
    }

    public StudentEntry() {
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }
}
