package search;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Boj10815 {
    static Scanner scanner = new Scanner(System.in);
    InputStream in;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) {
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            System.out.print(number);
        }

    }
}
