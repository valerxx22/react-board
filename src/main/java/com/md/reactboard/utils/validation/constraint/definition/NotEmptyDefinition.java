package com.md.reactboard.utils.validation.constraint.definition;

import com.md.reactboard.utils.validation.constraint.ConstraintDefinition;
import org.hibernate.validator.constraints.NotEmpty;

public class NotEmptyDefinition extends ConstraintDefinition<NotEmptyDefinition, NotEmpty> {

    public NotEmptyDefinition(NotEmpty constraint){
        this();
        message(constraint.message());
    }
    public NotEmptyDefinition() {
        super(NotEmpty.class);
    }
}
