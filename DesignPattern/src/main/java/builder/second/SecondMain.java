package builder.second;

public class SecondMain {
    public static void main(String args []){
        Computer computer = ComputerBuilder
                .start()
                .setCpu("i7")
                .setRam("32G")
                .build();

        System.out.println(computer.toString());

    }
}
