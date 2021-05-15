package lecture.dynamic;

import java.util.Objects;

public class Fibo {
    static int[] memo;
    static int n;

    public static void main(String args[]) {
        memo = new int[1000];

    }

    static int fibo(int n) {
        if (n <= 1) {
            return n;
        } else {
            if (memo[n] > 0) {
                return memo[n];
            }
            memo[n] = fibo(n - 1) + fibo(n - 2);
            return memo[n];
        }
    }

    static int fibo2(int n) {
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];

    }
}
