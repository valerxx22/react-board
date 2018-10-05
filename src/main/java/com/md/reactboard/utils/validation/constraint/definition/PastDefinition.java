package com.md.reactboard.utils.validation.constraint.definition;

import com.md.reactboard.utils.validation.constraint.ConstraintDefinition;

import javax.validation.constraints.Past;

public class PastDefinition extends ConstraintDefinition<PastDefinition, Past> {

    public PastDefinition(Past constraint) {
        this();
        message(constraint.message());
    }

    public PastDefinition() {
        super(Past.class);
    }

}
