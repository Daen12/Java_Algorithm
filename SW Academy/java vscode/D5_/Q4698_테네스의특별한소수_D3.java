import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Q4698_테네스의특별한소수_D3 {
    public static void main(String[] args) {
        // 소수 - 1과 자기자신만으로 나누어떨어짐
        // D를 포함하는 소수
        // A이상B이하 & 특별한 소수의 개수
        int N = 1000000;
        boolean[] primes = new boolean[N + 1];
        List<Integer> list = new ArrayList<>();
        primes[0] = primes[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (!primes[i]) { // false(소수)라면
                for (int j = i * i; j <= N; j += i) {
                    primes[j] = true; // i의 배수들에 소수아님 표시
                }
            }
        }
        for (int i = 1; i < N; i++) { // 리스트에 소수 담기
            if (!primes[i]) {
                list.add(i);
            }
        }

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int D = in.nextInt();
            int A = in.nextInt();
            int B = in.nextInt();
            int result = 0;

            for (int i = 0; i < list.size(); i++) { // 배열 하나씩 확인
                int prime = list.get(i);
                if (A <= prime && prime <= B) { // 범위안에 들면서
                    while (prime > 0) {
                        if (prime % 10 == D) {
                            result++;
                            break;
                        } else {
                            prime = prime / 10;
                        }
                    }
                }
            }
            System.out.printf("#%d %d\n", t, result);

            // for (int i = A; i <= B; i++) { // i가 숫자!
            // boolean isPrime = true;
            // for (int j = 2; j <= Math.sqrt(i); j++) { // 1부터 i까지 수로 나누었을때 나머지0이면 count++
            // if (i % j == 0) {
            // isPrime = false;
            // break;
            // }
            // }
            // if (isPrime) {
            // // i에 대해서 각 자리 보고 D있는지 확인
            // int temp = i;
            // while (temp > 0) {
            // if (temp % 10 == D) {
            // result++;
            // break;
            // } else {
            // temp = temp / 10;
            // }
            // }
            // }
            // }
        }
    }
}