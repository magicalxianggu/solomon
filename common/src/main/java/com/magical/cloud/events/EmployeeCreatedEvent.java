package com.magical.cloud.events;

import com.magical.cloud.domain.EmployeeID;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * Created by zhouxp on 2017/10/24
 */
public class EmployeeCreatedEvent {

    @TargetAggregateIdentifier
    private EmployeeID employeeID;

    private String employeeName;

    private String employeeNO;

    public EmployeeCreatedEvent(EmployeeID employeeID, String employeeName, String employeeNO) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeNO = employeeNO;
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
