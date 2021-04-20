package builderpattern.practice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class UserDtoTest {
    @Test
    void dto() {
        UserDto.Builder builder = new UserDto.Builder(null, "1234", "abcde@gmail.com");
        UserDto user = builder.address("Busan")
                .gender("Female")
                .phoneNUmber("")
                .build();
        System.out.println(user.toString());
    }

}