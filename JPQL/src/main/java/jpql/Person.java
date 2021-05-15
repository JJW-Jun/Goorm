package jpql;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Person {
    private String name;
    private int age;
    private String address;

}
