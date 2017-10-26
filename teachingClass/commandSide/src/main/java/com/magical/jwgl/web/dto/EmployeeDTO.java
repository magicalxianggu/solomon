package com.magical.jwgl.web.dto;

/**
 * Created by zhouxp on 2017/10/24
 */
public class EmployeeDTO {

    //ID
    private String employeeID;

    //姓名
    private String employeeName;

    //教员编号
    private String employeeNO;

    public EmployeeDTO(String teacherID, String employeeName, String teacherNO) {
        this.employeeID = teacherID;
        this.employeeName = employeeName;
        this.employeeNO = teacherNO;
    }

    public EmployeeDTO() {
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeNO() {
        return employeeNO;
    }

    public void setEmployeeNO(String employeeNO) {
        this.employeeNO = employeeNO;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
