package builder.practice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter
@ToString(exclude = {"password"})
public class UserDto implements CommonBuilder {

    private Long id;
    private final String name;
    private final String password;
    private String email;
    private String address;
    private String gender;
    private String phoneNUmber;

    @Override
    public Object build() {
        return null;
    }


    public static class Builder {
        private Long id;
        private final String name;
        private final String password;
        private final String email;
        private String address;
        private String gender;
        private String phoneNUmber;


        // 필수 인자를 받는 것
        public Builder(String name, String password, String email) {
            this.name = name;
            this.password = password;
            this.email = email;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder phoneNUmber(String phoneNUmber) {
            this.phoneNUmber = phoneNUmber;
            return this;
        }

        public UserDto build() {
            return new UserDto(this);
        }

    }

    public UserDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.password = builder.password;
        this.email = builder.email;
        this.address = builder.address;
        this.gender = builder.gender;
        this.phoneNUmber = builder.phoneNUmber;
    }

}