package com.magical.jwgl.command.aggregates;

import com.magical.cloud.commands.CreateEmployeeCommand;
import com.magical.cloud.domain.EmployeeID;
import com.magical.cloud.events.EmployeeCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/**
 * Created by zhouxp on 2017/10/24
 */
@Aggregate
public class Employee
{
    @AggregateIdentifier
    private EmployeeID employeeID;

    private String employeeName;

    private String employeeNO;

    public Employee() {
    }

    @CommandHandler
    public Employee(CreateEmployeeCommand command) {
        apply(new EmployeeCreatedEvent(command.getEmployeeID(),command.getEmployeeName(),command.getEmployeeNO()));
    }

    @EventHandler
    public void on(EmployeeCreatedEvent event){
        this.employeeID = event.getEmployeeID();
        this.employeeName = event.getEmployeeName();
        this.employeeNO = event.getEmployeeNO();
    }

    public EmployeeID getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeNO() {
        return employeeNO;
    }
}
