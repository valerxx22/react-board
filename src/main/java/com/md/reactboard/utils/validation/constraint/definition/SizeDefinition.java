package com.md.reactboard.utils.validation.constraint.definition;

import com.md.reactboard.utils.validation.constraint.ConstraintDefinition;

import javax.validation.constraints.Size;

public class SizeDefinition extends ConstraintDefinition<SizeDefinition, Size> {

    public SizeDefinition(Size constraint) {
        this();
        message(constraint.message()).min(constraint.min()).max(constraint.max());
    }

    public SizeDefinition() {
        super(Size.class);
    }

    public SizeDefinition min(int min) {
        addParameter("min", min);
        return this;
    }

    public SizeDefinition max(int max) {
        addParameter("max", max);
        return this;
    }
}
