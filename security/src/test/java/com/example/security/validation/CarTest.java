package com.example.security.validation;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.AssertTrue;
import javax.validation.executable.ExecutableValidator;

import java.util.Collections;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();


    @Test
    void carTest() {
        Person driver = Person.builder()
                .name(null)
                .age(-3)
                .driverLicenseNumber(null)
                .build();

        Car car = Car.builder()
                .model("아반떼")
                .registrationNumber(null)
                .drivers(Collections.singletonList(driver))
                .build();
        System.out.println("==================");
        System.out.println(validator.validate(driver));
//        System.out.println(validator.validate(car));
        System.out.println("==================");
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

        assertThat(constraintViolations)
                .extracting(ConstraintViolation::getMessage)
                .containsOnly(
                        "자동차번호가 있어야 합니다.",
                        "운전자의 나이는 18세 이상이어야 합니다.",
                        "운전자는 운전면허번호이 있어야 합니다."
                );
    }

//    @AssertTrue(message = "운전자 중 &apos;송정훈&apos; 이 있어야 합니다.")
//    public boolean containsDriverSong() {
//        return drivers.stream()
//                .map(Person::getName)
//                .anyMatch(it -> it.equals("송정훈"));
//
//    }

//    @Test
//    void carTest_addDriver_ReturnValue() throws Exception {
//        Person driver = Person.builder()
//                .name("아이유")
//                .age(20)
//                .driverLicenseNumber("50002200")
//                .build();
//
//        Car car = Car.builder()
//                .model("아반떼")
//                .registrationNumber("2000")
//                .drivers(Collections.singletonList(driver))
//                .build();
//
//        ExecutableValidator executableValidator = validator.forExecutables();
//
//        Set<ConstraintViolation<Car>> constraintViolations = executableValidator
//                .validateReturnValue(
//                        car,
//                        Car.class.getMethod("containsDriverSong"),
//                        car.containsDriverSong()
//                );
//
//        assertThat(constraintViolations)
//                .extracting(ConstraintViolation::getMessage)
//                .containsOnly(
//                        "운전자 중 &apos;송정훈&apos; 이 있어야 합니다."
//                );
//    }

}