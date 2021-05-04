import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.function.Predicate;

//https://www.daleseo.com/java8-lambdas-part1-3/
@Data @ToString
public class Fruit {

    private String name;
    private String kind;
    private int weight;

    public Fruit(String name, String kind, int weight) {
        this.name = name;
        this.kind = kind;
        this.weight = weight;
    }

    public boolean isApple() {
        return "Apple".equals(getName());
    }


}
