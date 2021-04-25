package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2961 {
    private static int n;
    private static int min = Integer.MAX_VALUE;
    private static int[] sourArray;
    private static int[] bitterArray;
    private static boolean[] selectedArray;

    private static void sol(int count, int sour, int bitter) {
        if (count == n) {
            int selectionCount = 0;
            for (int j = 0; j < n; j++) {
                if (selectedArray[j]) {
                    selectionCount++;
                }
            }
            if (selectionCount > 0) {
                min = Math.min(min, Math.abs(sour - bitter));
            }
            return;
        }

        selectedArray[count] = true;
        sol(count + 1, sour * sourArray[count], bitter + bitterArray[count]);

        selectedArray[count] = false;
        sol(count + 1, sour, bitter);



    }

    public static void main(String args[]) throws IOException {
        InputStream in;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        sourArray = new int[n];
        bitterArray = new int[n];
        selectedArray = new boolean[n];
//        EntityManager.find( )

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            sourArray[i] = Integer.parseInt(st.nextToken());
            bitterArray[i] = Integer.parseInt(st.nextToken());
        }

        sol(0, 1, 0);
        System.out.println(min);
    }

}
