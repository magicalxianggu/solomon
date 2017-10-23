package com.magical.jwgl.web.dto;

/**
 * Created by zhouxp on 2017/10/23
 */
public class StudentDTO {

    private String id;
    private String studentName;

    public StudentDTO(String id, String studentName) {
        this.id = id;
        this.studentName = studentName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
