package com.md.reactboard.utils.validation.constraint.definition;

import com.md.reactboard.utils.validation.constraint.ConstraintDefinition;

import javax.validation.constraints.AssertFalse;

public class AssertFalseDefinition extends ConstraintDefinition<AssertFalseDefinition, AssertFalse> {

    public AssertFalseDefinition(AssertFalse constraint) {
        this();
        message(constraint.message());
    }

    public AssertFalseDefinition() {
        super(AssertFalse.class);
    }
}
