package com.magical.cloud.domain;

import org.axonframework.common.Assert;
import org.axonframework.common.IdentifierFactory;

import java.io.Serializable;

/**
 * Created by zhouxp on 2017/10/24
 */
public class EmployeeID implements Serializable {

    private final String identifier;
    private final int hashCode;

    public EmployeeID() {
        this.identifier = IdentifierFactory.getInstance().generateIdentifier();
        this.hashCode = identifier.hashCode();
    }

    public EmployeeID(String identifier) {
        Assert.notNull(identifier, ()->"Identifier may not be null");
        this.identifier = identifier;
        this.hashCode = identifier.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentID)) return false;

        EmployeeID employeeID = (EmployeeID) o;

        return identifier.equals(employeeID.identifier);
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }

    @Override
    public String toString() {
        return this.identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
