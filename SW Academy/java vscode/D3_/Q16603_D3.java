
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q16603_D3 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int seq = in.nextInt();
            int n = in.nextInt();
            int m = in.nextInt();
            int turn = in.nextInt();

            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = in.nextInt();
                }
            }
            int[][] finalMap = new int[n][m];
            int turnCount = 0;
            while (turnCount < turn) {
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < m; c++) {
                        // 만약 r=0이면, dir = 0부터 움직임.
                        if (r == 0 && c + 1 < m) {
                            finalMap[r][c + 1] = map[r][c];
                        } else if (c == m - 1 && r + 1 < n) {
                            finalMap[r + 1][c] = map[r][c];
                        } else if (r == n - 1 && c - 1 >= 0) {
                            finalMap[r][c - 1] = map[r][c];
                        } else if (c == 0 && r - 1 >= 0) {
                            finalMap[r - 1][c] = map[r][c];
                        }
                    }
                }
                map = finalMap;
                turnCount++;
                if (turnCount < turn)
                    finalMap = new int[n][m];
            }
            System.out.println("#" + seq);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(finalMap[i][j] + " ");

                }
                System.out.println();
            }
        }
    }
}
