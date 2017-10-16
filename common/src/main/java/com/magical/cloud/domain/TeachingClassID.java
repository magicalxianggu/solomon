package com.magical.cloud.domain;


import org.axonframework.common.Assert;
import org.axonframework.common.IdentifierFactory;

import java.io.Serializable;

public class TeachingClassID implements Serializable {

    private static final long serialVersionUID = -4163440749566043686L;

    private final String identifier;
    private final int hashCode;

    public TeachingClassID() {
        this.identifier = IdentifierFactory.getInstance().generateIdentifier();
        this.hashCode = identifier.hashCode();
    }

    public TeachingClassID(String identifier) {
        Assert.notNull(identifier, ()->"Identifier may not be null");
        this.identifier = identifier;
        this.hashCode = identifier.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeachingClassID)) return false;

        TeachingClassID orderId = (TeachingClassID) o;

        return identifier.equals(orderId.identifier);
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
