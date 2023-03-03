import java.util.Scanner;

public class Q2559_수열_silver3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // 전체 날짜의 수
        int K = in.nextInt(); // 연속적 날짜 수 합
        int[] days = new int[N];
        for (int i = 0; i < N; i++) {
            days[i] = in.nextInt();
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= N - K; i++) {
            int localSum = 0;
            for (int j = i; j < i + K; j++) {
                localSum += days[j];
            }
            // max = Math.max(max, localSum);
            max = max < localSum ? localSum : max; // 최대갱신
        }
        System.out.println(max);
    }
}
