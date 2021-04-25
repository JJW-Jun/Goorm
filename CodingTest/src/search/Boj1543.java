package search;

import java.util.Scanner;

public class Boj1543 {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String word = scan.nextLine();
        int count = 0;
        int answer = 0;
        scan.close();

        while (count < str.length() - word.length() + 1) {
            if (word.equals(str.substring(count, count + word.length()))) {
                answer += 1;
                count += word.length();
                continue;
            }
            ++count;
        }
        System.out.println(answer);

    }
}