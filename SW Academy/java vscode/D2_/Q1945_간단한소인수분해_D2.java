import java.util.Scanner;

public class Q1945_간단한소인수분해_D2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {

            // 소인수분해 할 배열
            int[] primes = { 2, 3, 5, 7, 11 };
            int N = in.nextInt();
            System.out.print("#" + t + " ");
            for (int i = 0; i < 5; i++) {
                // 각각의 소인수에 대해서
                int prime = primes[i];
                int count = 0;
                while (N % prime == 0) {
                    N = N / prime;
                    count++;
                }
                System.out.print(count + " ");
            }
            System.out.println();
        }
    }
}
