package com.example.security.validation;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void personTest() {
        Person person = Person.builder()
                .name("송정훈")
                .age(-1)
                .build();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);

        assertThat(constraintViolations)
                .extracting(ConstraintViolation::getMessage)
                .containsOnly("나이는 0 이상이어야 합니다.");
    }

}