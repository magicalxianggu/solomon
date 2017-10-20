package com.magical.cloud.commands;

import com.magical.cloud.domain.StudentID;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * Created by zhouxp on 2017/10/20
 */
public class CreateStudentCommand {

    @TargetAggregateIdentifier
    private StudentID studentID;

    private String studentName;

    private String classID;

    public CreateStudentCommand(String studentName, String classID) {
        this.studentID = new StudentID();
        this.studentName = studentName;
        this.classID = classID;
    }

    public StudentID getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getClassID() {
        return classID;
    }
}
