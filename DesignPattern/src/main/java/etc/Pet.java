package etc;

class Polymorphism {
}


public abstract class Pet {
    public abstract void talk();
}


class Cat extends Pet {

    @Override
    public void talk() {
        System.out.println("야옹");
    }
}


class Dog extends Pet {

    @Override
    public void talk() {
        System.out.println("멍멍");
    }
}

class Bird extends Pet {

    @Override
    public void talk() {
        System.out.println("짹짹");
    }
}


class Main {
    public static void main(String args[]) {
        Pet pet = new Dog();
        pet.talk();

    }
}