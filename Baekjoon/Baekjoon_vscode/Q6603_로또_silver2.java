import java.util.Scanner;

public class Q6603_로또_silver2 {
    // 주어진 수에 대하여
    // 조합을 구하는 문제. 조합의 경우의 수!
    // visited 사용
    static int[] nums;
    static int N;
    static StringBuilder sb;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 몇줄 나올지 모르는 상황
        while (true) {
            N = in.nextInt();
            if (N == 0) {
                break;
            }
            sb = new StringBuilder();
            nums = new int[N];
            visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                nums[i] = in.nextInt();
            }
            Combination(0, 0);
            System.out.println(sb);
        }

    }

    public static void Combination(int depth, int idx) {
        if (depth == 6) {
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    sb.append(nums[i] + " ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < N; i++) {
            visited[i] = true;
            Combination(depth + 1, i + 1);
            visited[i] = false;
        }
    }

}
