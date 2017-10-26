package com.magical.jwgl.query.handles;

import com.magical.cloud.events.EmployeeCreatedEvent;
import com.magical.jwgl.query.entries.EmployeeEntry;
import com.magical.jwgl.query.repository.EmployeeQueryRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhouxp on 2017/10/25
 */
@Component
public class EmployeeEventHandler {

    @Autowired
    private EmployeeQueryRepository repository;

    @EventHandler
    public void on(EmployeeCreatedEvent event){

        repository.save(new EmployeeEntry(event.getEmployeeID().getIdentifier(),event.getEmployeeName(),event.getEmployeeNO()));

    }
}
