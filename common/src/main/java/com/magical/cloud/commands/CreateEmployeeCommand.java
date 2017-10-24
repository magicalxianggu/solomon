package com.magical.cloud.commands;

import com.magical.cloud.domain.EmployeeID;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateIdentifier;

/**
 * Created by zhouxp on 2017/10/24
 */
public class CreateEmployeeCommand {

    @TargetAggregateIdentifier
    private EmployeeID employeeID;

    private String employeeName;

    private String employeeNO;

    public CreateEmployeeCommand(String employeeName, String employeeNO) {
        this.employeeID = new EmployeeID();
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
