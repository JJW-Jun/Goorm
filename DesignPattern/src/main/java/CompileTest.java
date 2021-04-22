import java.util.Objects;

public class CompileTest {
    private final int number = 3;

    public int sum(int n) {
        int num = Objects.requireNonNull(n, "Error");
        return number + num;
    }

    public static void main(String args[]) {
        CompileTest compileTest = new CompileTest();
        compileTest.sum(3);

    }
}
