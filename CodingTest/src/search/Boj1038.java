import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Boj1038 {

    static List<Integer> lst = new ArrayList<>();

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int index = Integer.parseInt(number);


        for (int i = 0; i < 10; i++) {
            addElements(i, 1, lst);
        }

        Collections.sort(lst);

        if (index > 1022) {
            System.out.println(-1);
        } else {
            System.out.println(lst.get(index));
        }
    }


    static List addElements(long number, int digit, List lst) {
        if (digit > 10) {
            return lst;
        }

        lst.add(number);

        for (int j = 0; j < 10; j++) {
            if (number % 10 > j) {
                addElements((number * 10) + j, digit + 1, lst);
            }
        }
        return lst;
    }
}

//public class Boj1038 {
//    public static void main(String args[]) {
//        Scanner scanner = new Scanner(System.in);
//        String number = scanner.nextLine();
//        addNumber(number);
//    }
//
//
//    // "321" 32, 21
//    static boolean checkNumber(String number) {
//        for (int i = 0; i < number.length() - 1; i++) {
//            if (number.charAt(i) <= number.charAt(i + 1)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    static List<Integer> lst = new ArrayList<>();
//
//    static void addNumber(String number) {
//        int start = 0;
//        int object = Integer.parseInt(number);
//        while (lst.size() <= object) {
//            if (checkNumber(String.valueOf(start))) {
//                lst.add(start);
//            }
//            start++;
//        }
//        System.out.println(lst.get(object));
//    }
//}