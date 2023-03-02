import java.util.Arrays;
import java.util.Scanner;

public class Q1860_진기의최고급붕어빵_D3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            String answer = "Possible";
            int N = in.nextInt(); // 몇명
            int M = in.nextInt(); // 몇초동안 //4
            int K = in.nextInt(); // 몇개 붕어빵? //3

            int[] arrival = new int[N];
            for (int n = 0; n < N; n++) {
                arrival[n] = in.nextInt();
            }
            Arrays.sort(arrival); // 먼저 온 사람부터 정렬!
            int fish = 0;
            int rounds = 0;
            for (int i = 0; i < N; i++) { // 도착시간 짧은거부터
                if (arrival[i] < M) {
                    answer = "Impossible";
                } else {
                    int addRounds = arrival[i] / M - rounds; // 도착할때까지 몇번 구웠는지
                    rounds = arrival[i] / M;
                    fish += K * addRounds;
                    if (fish >= 1) {
                        fish--;
                    } else {
                        answer = "Impossible";
                    }
                }
            }
            System.out.println("#" + t + " " + answer);
        }
    }
}
