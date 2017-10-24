package com.magical.jwgl.command.config;

import com.magical.jwgl.command.aggregates.Employee;
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

    @Bean(name = "studentRepository")
    public Repository<Employee> repository(EventStore eventStore){
        return new EventSourcingRepository<Employee>(Employee.class, eventStore);
    }
}
