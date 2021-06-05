package etc;

public class A {
    public static void doIt(){
        System.out.println("Parent method : A class method doIt");
    }

    public void doThat(){
        System.out.println("Parent method : A class method doThat");
    }
}


class A1 extends A{
    public static void doit(){
        System.out.println("");
    }
}
