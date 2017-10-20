package com.magical.jwgl.command.aggregates;

import com.magical.cloud.commands.CreateStudentCommand;
import com.magical.cloud.domain.StudentID;
import com.magical.cloud.events.StudentCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateRoot;
import org.axonframework.eventhandling.EventHandler;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/**
 * Created by zhouxp on 2017/10/20
 */
@AggregateRoot
public class Student {

  @AggregateIdentifier
  private StudentID studentID;

  private String studentName;

  private String classID;

  public Student() {
  }

  @CommandHandler
  public Student(CreateStudentCommand command) {
    apply(new StudentCreatedEvent(command.getStudentID(),command.getStudentName(),command.getClassID()));
  }

  @EventHandler
  public void on(StudentCreatedEvent event){
    this.studentID = event.getStudentID();
    this.studentName = event.getStudentName();
    this.classID = event.getClassID();
  }
}
