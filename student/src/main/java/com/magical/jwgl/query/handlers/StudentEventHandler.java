package com.magical.jwgl.query.handlers;

import com.magical.cloud.events.StudentCreatedEvent;
import com.magical.jwgl.query.entries.StudentEntry;
import com.magical.jwgl.query.repository.StudentQueryRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhouxp on 2017/10/20
 */
@Component
public class StudentEventHandler {

    @Autowired
    private StudentQueryRepository studentRepository;

    @EventHandler
    public void on(StudentCreatedEvent event) {

        StudentEntry studentEntry = new StudentEntry(event.getStudentID().getIdentifier(), event.getStudentName(), event.getClassID());

        studentRepository.save(studentEntry);
    }
}
