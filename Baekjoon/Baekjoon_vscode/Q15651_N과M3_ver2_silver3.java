import java.util.Scanner;

public class Q15651_N과M3_ver2_silver3 {
    static int N = 0, M = 0;
    static int[] arr; // M개의 수를 고르자 (바구니)
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        arr = new int[M];

        backTracking(0);
        System.out.println(sb);
    }

    public static void backTracking(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            arr[k] = i;
            backTracking(k + 1);
        }
    }
}
