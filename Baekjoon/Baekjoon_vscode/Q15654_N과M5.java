import java.util.Arrays;
import java.util.Scanner;

class Q15654_N과M5 {
    static int N, M;
    static int[] nums;
    static int[] arr;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        nums = new int[N];
        isUsed = new boolean[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        arr = new int[M];
        backTracking(0);
        System.out.println(sb);
    }

    public static void backTracking(int idx) {
        if (idx == M) {// 깊이가 M에 도달하면
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                arr[idx] = nums[i];
                isUsed[i] = true;
                backTracking(idx + 1);
                isUsed[i] = false;
            }
        }
    }
}