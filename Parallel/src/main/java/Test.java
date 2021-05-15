import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Test<T> {
    static Predicate<String> pre = n->n.equals("a");
    public static void main(String[] args) throws InterruptedException {
        var list = new ArrayList<String>(); // infers ArrayList<String>


        List<String> fruit = new ArrayList<>();
        fruit.add("Apple");
        fruit.add("Banana");
        fruit.add("Coconut");
        final var test = "St";
        var stream = fruit.stream();

//        BankAccount b = new BankAccount();
//        Parent p = new Parent(b);
//        Child c = new Child(b);
//        p.start();   // start(): 쓰레드를 실행하는 메서드
//        c.start();
//        p.join();    // join(): 쓰레드가 끝나기를 기다리는 메서드
//        c.join();
//        System.out.println("balance = " + b.getBalance());
    }
}

// 계좌
class BankAccount {
    int balance;

    void deposit(int amount) {
        int temp = balance + amount;
        System.out.print("+");
        balance = temp;
    }

    void withdraw(int amount) {
        int temp = balance - amount;
        System.out.print("-");
        balance = temp;
    }

    int getBalance() {
        return balance;
    }
}
//class BankAccount {
//    int balance;
//    void deposit(int amount) {
//        balance = balance + amount;
//    }
//    void withdraw(int amount) {
//        balance = balance - amount;
//    }
//    int getBalance() {
//        return balance;
//    }
//}

// 입금 프로세스
class Parent extends Thread {
    BankAccount b;

    Parent(BankAccount b) {
        this.b = b;
    }

    public void run() {   // run(): 쓰레드가 실제로 동작하는 부분(치환)
        for (int i = 0; i < 100; i++)
            b.deposit(1000);
    }
}

// 출금 프로세스
class Child extends Thread {
    BankAccount b;

    Child(BankAccount b) {
        this.b = b;
    }

    public void run() {
        for (int i = 0; i < 100; i++)
            b.withdraw(1000);
    }
}
