package com.md.reactboard.utils.validation.constraint.definition;

import com.md.reactboard.utils.validation.constraint.ConstraintDefinition;

import javax.validation.constraints.Future;

public class FutureDefinition extends ConstraintDefinition<FutureDefinition, Future> {

    public FutureDefinition(Future constraint) {
        this();
        message(constraint.message());
    }

    public FutureDefinition() {
        super(Future.class);
    }

}
