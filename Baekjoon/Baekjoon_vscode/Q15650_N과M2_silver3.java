import java.util.Scanner;

public class Q15650_N과M2_silver3 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        arr = new int[M];

        DFS(1, 0);
    }

    public static void DFS(int at, int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = at; i <= N; i++) {
            arr[k] = i;
            DFS(i + 1, k + 1);
        }
    }
}
