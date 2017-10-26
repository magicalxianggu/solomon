package com.magical.jwgl.config;

import com.magical.jwgl.aggregates.TeachingClass;
import org.axonframework.commandhandling.model.Repository;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by
 */
@Configuration
public class PersistenceConfiguration {

    @Bean(name = "teachingClassRepository")
    public Repository<TeachingClass> repository(EventStore eventStore){
        return new EventSourcingRepository<TeachingClass>(TeachingClass.class, eventStore);
    }
}
