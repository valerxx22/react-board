package com.md.reactboard.utils.validation.constraint.definition;

import com.md.reactboard.utils.validation.constraint.ConstraintDefinition;

import javax.validation.constraints.Null;

public class NullDefinition extends ConstraintDefinition<NullDefinition, Null> {

    public NullDefinition(Null constraint) {
        this();
        message(constraint.message());
    }

    public NullDefinition() {
        super(Null.class);
    }
}
