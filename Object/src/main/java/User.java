import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class User {
    private Long id;
    private String name;
    private String address;
    private int age;
    private String phoneNumber;
    private String gender;


    public boolean liveSeoul() {
        return "Seoul".equals(getAddress());
    }

    public boolean is20s() {
        if (getAge() <= 0) {
            throw new IllegalStateException("유효하지 않은 나이입니다.");
        }
        return getAge() >= 20 || getAge() < 30;
    }

    public boolean isMan() {
        return "Man".equals(getGender());
    }


    User(Long id, String name, String address, int age, String gender) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.gender = gender;
    }

    public static void main(String args[]) {
        User user1 = new User(1L, "김태영", "Seoul", 25, "Man");
        User user2 = new User(2L, "나경은", "Seoul", 32, "Woman");
        User user3 = new User(3L, "나태양", "Busan", 22, "Man");
        User user4 = new User(4L, "라지원", "Daegu", 42, "Woman");
        User user5 = new User(5L, "문정호", "Seoul", 29, "Man");
        User user6 = new User(6L, "변희연", "Busan", 17, "Woman");
        User user7 = new User(7L, "성유리", "Seoul", 34, "Woman");
        User user8 = new User(8L, "우지원", "Seoul", 25, "Man");
        User user9 = new User(9L, "정진우", "Seoul", 33, "Man");
        User user10 = new User(10L, "천성주", "Jeju", 22, "Man");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        users.add(user9);
        users.add(user10);

        users.stream().filter(User::isMan)
                      .filter(User::liveSeoul)
                      .filter(User::is20s)
                      .forEach(System.out::println);

    }

}
