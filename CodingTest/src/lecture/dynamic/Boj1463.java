//package lecture.dynamic;
//
//public class Boj1463 {
//    static int[] memoi;
//
//    public static void main(String args[]) {
//
//    }
//
//    static int cal(int n) {
//        if (n == 1) {
//            return 0;
//        }
//        if (memoi[n] > 0) {
//            return memoi[n];
//        }
//
//        memoi[n] = cal(n - 1) + 1;
//        if (n % 2 == 0) {
//            int temp = cal(n / 2) + 1;
//            if (memoi[n] > temp) {
//                memoi[n] = temp;
//            }
//        }
//    }
//}
