package com.magical.jwgl.query.entries;

import org.springframework.data.annotation.Id;

/**
 * Created by zhouxp on 2017/10/25
 */
public class EmployeeEntry {
    @Id
    private String employeeID;
    private String employeeName;
    private String employeeNO;

    public EmployeeEntry() {
    }

    public EmployeeEntry(String employeeID, String employeeName, String employeeNO) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeNO = employeeNO;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeNO() {
        return employeeNO;
    }

    public void setEmployeeNO(String employeeNO) {
        this.employeeNO = employeeNO;
    }
}
