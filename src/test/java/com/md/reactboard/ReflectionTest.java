package com.reactboard.web;

import com.reactboard.web.utils.validation.Validator;
import com.reactboard.web.web.rest.resource.CommentResource;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;


@WebAppConfiguration
@SpringBootTest
public class ReflectionTest {


    @Test
    public void getAnnotations() {
        System.out.println(Validator.extractConstraint(CommentResource.class));
    }

}
