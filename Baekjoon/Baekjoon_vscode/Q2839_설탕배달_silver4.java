import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2839_설탕배달_silver4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int answer = 0;
        // 11 = 6+5 = 3*2+5
        // 5가 커야함
        for (int i = 0; i <= N / 3; i++) {
            if ((N - 3 * i) % 5 == 0) {
                answer = i + ((N - 3 * i) / 5);
                break;
            } else if (i == N / 3) {
                answer = -1;
            }
        }
        System.out.println(answer);
    }
}
