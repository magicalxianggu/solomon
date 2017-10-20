package com.magical.jwgl;

import com.magical.cloud.commands.CreateStudentCommand;
import com.magical.cloud.domain.StudentID;
import com.magical.cloud.events.StudentCreatedEvent;
import com.magical.jwgl.command.aggregates.Student;
import com.magical.jwgl.query.repository.StudentQueryRepository;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by zhouxp on 2017/10/20
 */
public class StudentCommandHandlerTest {

    private AggregateTestFixture<Student> fixture;

    private StudentQueryRepository studentQueryRepository;

    @Before
    public void setUp() {
        studentQueryRepository = Mockito.mock(StudentQueryRepository.class);

        fixture = new AggregateTestFixture<>(Student.class);

    }


    @Test
    public void testHandleCreateStudent() throws Exception {

        CreateStudentCommand createStudentCommand = new CreateStudentCommand("zhpouxup","123456");

        fixture.given()
                .when(createStudentCommand)
                .expectEvents(new StudentCreatedEvent(createStudentCommand.getStudentID(),"zhpouxup","123456"));
    }

}
