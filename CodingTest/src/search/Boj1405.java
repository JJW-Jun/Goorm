import java.util.Scanner;

class Boj1405 {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static double[] percentage;
    static boolean[][] visited;
    static double answer;


    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        percentage = new double[4];

        //25 25 25 25
        // 1/4 1/4

        for (int i = 0; i < 4; i++) {
            percentage[i] = scan.nextInt() * (0.01);
        }

        visited = new boolean[30][30];
        answer = 0;
        dfs(15, 15, 0, n, 1);
        System.out.println(answer);

    }


    static void dfs(int x, int y, int index, int n, double total) {

        if (index == n) {
            answer += total;
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 30 && ny >= 0 && ny < 30) {
                // BackTracking
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, index + 1, n, total * percentage[i]);
                    // 복귀 후 진행
                    visited[nx][ny] = false;
                }
            }

        }
    }
}