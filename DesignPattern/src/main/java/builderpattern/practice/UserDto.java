package builderpattern.practice;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private User user;


    private Long id;
    private String name;
    private String password;
    private String email;
    private String address;

    protected UserDto() {
    }

    @Builder
    public UserDto(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public UserDto start(String d) {
        return new UserDto();
    }

    public UserDto setPassword(String password) {
        return this;

    }

    public User build() {
        return this.user;
    }

}