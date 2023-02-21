import java.util.Scanner;

public class Q8320_직사각형을만드는_bronze2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // 6
        int n = 1;
        int t = 0;
        int sum = 0;
        while (N / n >= n) {
            sum += N / n++ - t++;

        }
        System.out.println(sum);
    }
}
