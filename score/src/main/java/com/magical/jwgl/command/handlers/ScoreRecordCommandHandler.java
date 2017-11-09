package com.magical.jwgl.command.handlers;

import com.magical.cloud.commands.CreateTeachingClassScoreCommand;
import com.magical.cloud.domain.EvaluateCourse;
import com.magical.jwgl.command.aggergates.TeachingClassScoreRecord;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhouxp on 2017/10/23
 */
@Component
public class ScoreRecordCommandHandler {

    @Autowired
    private Repository<TeachingClassScoreRecord> repository;

    @CommandHandler
    public void handler(CreateTeachingClassScoreCommand command) throws Exception {


        EvaluateCourse evaluateCourse = new EvaluateCourse(command.getCourseID(),"","");


TeachingClassScoreRecord teachingClassScore =
        new TeachingClassScoreRecord(
                command.getTeachingClassScoreID(),
                command.getTeachingClassID(),
                command.getTermID(),
                evaluateCourse,
                command.getCourseEvaluateStandardID()  );
        repository.newInstance(() -> teachingClassScore);
    }
}


