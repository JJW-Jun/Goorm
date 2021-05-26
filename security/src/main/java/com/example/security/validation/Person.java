package com.example.security.validation;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;


interface PersonGroups {
    interface Driver {
    }
}

@Builder
@Getter
public class Person {
    @NotEmpty(message = "이름이 있어야 합니다.")
    private String name;

    @Positive(message = "나이는 0 이상이어야 합니다.")
    @Min(value = 18, message = "운전자의 나이는 18세 이상이어야 합니다.", groups = PersonGroups.Driver.class)
    private int age;

    @NotEmpty(message = "운전자는 운전면허번호가 있어야 합니다.", groups = PersonGroups.Driver.class)
    private String driverLicenseNumber;
}
