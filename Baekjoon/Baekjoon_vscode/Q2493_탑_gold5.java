import java.util.Scanner;

public class Q2493_탑_gold5 {
    // 6,9,5,7,4
    // 왼쪽 <-으로 발사
    // 어느 탑에서 수신하는지
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }

        for (int i = 1; i < N; i++) {
            nums[i] = in.nextInt();
            t = i - 1;
            while (nums[t] > nums[i]) {
                t--;
            }
        }

    }
}
