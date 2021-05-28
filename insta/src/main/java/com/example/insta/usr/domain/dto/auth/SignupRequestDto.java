package com.example.insta.usr.domain.dto.auth;


import com.example.insta.usr.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class SignupRequestDto {
    @Size(min = 1, max = 10)
    private String username;

    @NotNull @NotBlank
    private String password;

    @NotNull @NotEmpty
    private String email;
    @NotNull
    private String name;
    private String role;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .role(role)
                .build();
    }

}
