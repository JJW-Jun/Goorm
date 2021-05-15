import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Apple {
    static List<Apple> apples = new ArrayList<>();
    private String color;
    private int weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public boolean over3Kg() {
        return weight>3;
    }

    public boolean colorGreen() {
        return "green".equals(getColor());
    }

    static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple))
                result.add(apple);
        }
        return result;
    }

    public static void main(String args[]) {
        Apple apple = new Apple("green", 3);
        Apple apple2 = new Apple("red", 2);
        Apple apple3 = new Apple("green", 3);
        Apple apple4 = new Apple("green", 4);
        Apple apple5 = new Apple("red", 1);
        apples.add(apple5);
        apples.add(apple4);
        apples.add(apple3);
        apples.add(apple2);
        apples.add(apple);
        filterApples(apples, new AppleHeavyWeightPredicate()).forEach(System.out::println);
        System.out.println(filterApples(apples, new Test23()));
    }
}


interface ApplePredicate {
    boolean test(Apple apple);
}

interface ApplePredicate2 {
    boolean test(List<Apple> apples);
}


class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}

class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 2;
    }
}

class Test23 implements ApplePredicate {
    ApplePredicate a = new AppleGreenColorPredicate();
    AppleHeavyWeightPredicate b = new AppleHeavyWeightPredicate();

    @Override
    public boolean test(Apple apple) {
        return a.test(apple) && b.test(apple);
    }
}