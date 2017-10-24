package com.magical.jwgl.web.dto;

/**
 * Created by zhouxp on 2017/10/24
 */
public class TeacherDTO {

    //ID
    private String teacherID;

    //姓名
    private String teacherName;

    //教员编号
    private String teacherNO;

    public TeacherDTO(String teacherID, String teacherName, String teacherNO) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.teacherNO = teacherNO;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherNO() {
        return teacherNO;
    }

    public void setTeacherNO(String teacherNO) {
        this.teacherNO = teacherNO;
    }
}
