import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

//https://www.daleseo.com/java8-lambdas-part1-3/
@Data
@ToString
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Fruit)) {
            return false;
        }

//        if (o == null || getClass() != o.getClass()) // 2
//            return false;
        Fruit fruit = (Fruit) o; // 3
        return weight == fruit.weight &&
                Objects.equals(name, fruit.name) &&
                Objects.equals(kind, fruit.kind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, kind, weight);
    }
}
