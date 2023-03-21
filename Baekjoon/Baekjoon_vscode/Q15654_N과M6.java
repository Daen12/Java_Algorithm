import java.util.Arrays;
import java.util.Scanner;

class Q15654_N과M6 {
    static int N, M;
    static int[] nums;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        arr = new int[M];
        Combination(0, 0);
        System.out.println(sb);
    }

    public static void Combination(int idx, int c) {
        if (c == M) {// 깊이가 M에 도달하면
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        if (idx == N) {
            return;
        }
        arr[c] = nums[idx];
        Combination(idx + 1, c + 1);
        Combination(idx + 1, c);
    }
}