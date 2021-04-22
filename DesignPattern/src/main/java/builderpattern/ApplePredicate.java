package builderpattern;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.awt.Color.GREEN;
import static java.awt.Color.yellow;

public interface ApplePredicate {
    boolean test(Apple apple);
}

class AppleHeavyWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}

class AppleGreenColorPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }
    static Supplier<String> str = ()-> "dddd";
    static Consumer<String> t = x-> System.out.println("");

}


class Teest {
    public static void main(String args[]) {


    }

}

