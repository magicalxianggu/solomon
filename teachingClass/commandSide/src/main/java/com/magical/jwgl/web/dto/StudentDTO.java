package com.magical.jwgl.web.dto;

/**
 * Created by zhouxp on 2017/10/23
 */
public class StudentDTO {

    private String studentID;
    private String studentName;

    public StudentDTO(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
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
}
