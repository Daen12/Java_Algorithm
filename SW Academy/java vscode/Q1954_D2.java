import java.util.Arrays;
import java.util.Scanner;

public class Q1954_D2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int[][] arr = new int[N][N];
            int flag = N; // 처음 시작할 플래그
            int num = 1;
            int i = 0;
            int j = 0;

            while (num <= N * N) {
                // 오른쪽 옆으로 -->
                for (int c = j; c < j + flag; c++) {
                    arr[i][c] = num;
                    num++;
                    System.out.println(arr[i][c]);
                }
                if (flag == 1)
                    break;
                j = j + flag - 1;
                flag--;
                // 밑으로
                for (int r = i + 1; r <= i + flag; r++) {
                    arr[r][j] = num;
                    num++;
                    System.out.println(arr[r][j]);
                }
                i = i + flag;
                // 왼쪽 옆으로
                for (int c = j - 1; j - flag <= c; c--) {
                    arr[i][c] = num;
                    num++;
                    System.out.println(arr[i][c]);
                }
                j = j - flag;
                flag--;
                // 위로
                for (int r = i - 1; i - flag <= r; r--) {
                    arr[r][j] = num;
                    num++;
                    System.out.println(arr[r][j]);
                }
                i = i - flag;
                j += 1;

            }
            System.out.println("#" + t);
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    System.out.print(arr[r][c] + " ");
                }
                System.out.println();
            }
        }
    }
}
