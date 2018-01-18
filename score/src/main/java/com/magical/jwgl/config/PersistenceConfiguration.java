package com.magical.jwgl.config;

import com.magical.jwgl.command.aggergates.TeachingClassScoreRecord;
import org.axonframework.commandhandling.model.Repository;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Edison on 2017/3/28.
 */
@Configuration
public class PersistenceConfiguration {

    @Bean(name = "teachingClassScoreRecordRepository")
    public Repository<TeachingClassScoreRecord> repository(EventStore eventStore){
        return new EventSourcingRepository<TeachingClassScoreRecord>(TeachingClassScoreRecord.class, eventStore);
    }
}
