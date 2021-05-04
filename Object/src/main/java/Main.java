import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String args []){

        List<Fruit> fruits = new ArrayList<>();

        Fruit apple = new Fruit("Apple", "A", 2);
        Fruit banana = new Fruit("Banana", "B", 1);
        Fruit coconut = new Fruit("Coconut", "C", 3);


        fruits.add(apple);
        fruits.add(banana);
        fruits.add(coconut);
        // 필터에 이미 정보가 들어가있잖아. Fruit을 받아서 isApple 메서드를 실행하겠다.
        // 1번
        fruits.stream().filter(Fruit::isApple).forEach(System.out::println);
        // 2번
        fruits.stream().filter(Fruit->Fruit.getName().equals("Apple")).forEach(System.out::println);
    }
}
