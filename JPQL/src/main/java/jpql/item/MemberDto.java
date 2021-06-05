package jpql;

import lombok.Data;

@Data
public class MemberDto {
    private String username;
    public int age;

    public MemberDto(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
