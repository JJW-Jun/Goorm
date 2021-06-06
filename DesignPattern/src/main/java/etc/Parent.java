package etc;

class Parent {
    public static void doIt() {
        System.out.println("Parent method : doIt");
    }

    public void doThat() {
        System.out.println("Parent method : doThat");
    }
}


class Descendent extends Parent {
    public static void doit() {
        System.out.println("Descendent method : doIt");
    }

    public void doThat() {
        System.out.println("Descendent method : doThat");
    }
}

class Main2 {
    public static void main(String args[]) {
        Parent parent = new Descendent();
        Descendent descendent = new Descendent();
        parent.doIt();
        parent.doThat();
        descendent.doIt();

    }
}
