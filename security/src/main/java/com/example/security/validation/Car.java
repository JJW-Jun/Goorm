package com.example.security.validation;


import lombok.Builder;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.util.List;


@Builder
@Getter
public class Car {
    @NotEmpty(message = "모델명이 있어야 합니다.")
    private String model;

    @NotEmpty(message = "자동차번호가 있어야 합니다.")
    private String registrationNumber;

    @NotEmpty(message = "운전자는 한명 이상이어야 합니다.")
    private List<
            @NotNull(message = "운전자는 null 이 아니어야 합니다.")
            @ConvertGroup(from = Default.class, to = PersonGroups.Driver.class)
            @Valid Person> drivers;


    public void addDriver(@NotNull(message = "운전자는 null 이 아니어야 합니다.")
                          @ConvertGroup(to = PersonGroups.Driver.class)
                          @Valid Person driver) {
        drivers.add(driver);
    }
}
