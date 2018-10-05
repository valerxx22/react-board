package com.md.reactboard.utils.validation.constraint.definition;

import com.md.reactboard.utils.validation.constraint.ConstraintDefinition;

import javax.validation.constraints.Digits;

public class DigitsDefinition extends ConstraintDefinition<DigitsDefinition, Digits> {

    public DigitsDefinition(Digits constraint) {
        this();
        message(constraint.message()).integer(constraint.integer()).fraction(constraint.fraction());
    }

    public DigitsDefinition() {
        super(Digits.class);
    }

    public DigitsDefinition integer(int integer) {
        addParameter("integer", integer);
        return this;
    }

    public DigitsDefinition fraction(int fraction) {
        addParameter("fraction", fraction);
        return this;
    }
}
