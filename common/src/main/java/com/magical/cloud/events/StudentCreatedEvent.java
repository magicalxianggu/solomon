package com.magical.cloud.events;

import com.magical.cloud.domain.StudentID;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * Created by zhouxp on 2017/10/20
 */
public class StudentCreatedEvent {
    @TargetAggregateIdentifier
    private StudentID studentID;

    private String studentName;

    private String classID;

    public StudentCreatedEvent(StudentID studentID, String studentName, String classID) {
        this.studentID = studentID;
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
