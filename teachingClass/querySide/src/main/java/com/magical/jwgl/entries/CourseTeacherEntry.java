package com.magical.jwgl.entries;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "courseTeacher")
public class CourseTeacherEntry {
    @Id
    private String courseTeacherID;
    private String courseTeacherName;
    //上课教员类型
    private String teacherPosition;

    public CourseTeacherEntry(String courseTeacherID, String courseTeacherName, String teacherPosition) {
        this.courseTeacherID = courseTeacherID;
        this.courseTeacherName = courseTeacherName;
        this.teacherPosition = teacherPosition;
    }

    public String getCourseTeacherID() {
        return courseTeacherID;
    }

    public void setCourseTeacherID(String courseTeacherID) {
        this.courseTeacherID = courseTeacherID;
    }

    public String getCourseTeacherName() {
        return courseTeacherName;
    }

    public void setCourseTeacherName(String courseTeacherName) {
        this.courseTeacherName = courseTeacherName;
    }

    public String getTeacherPosition() {
        return teacherPosition;
    }

    public void setTeacherPosition(String teacherPosition) {
        this.teacherPosition = teacherPosition;
    }
}
