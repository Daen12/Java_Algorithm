public class P_거듭제곱_재귀_팩토리얼 {
    public static void main(String[] args) {
        int N = 10;
        int C = 2;
        System.out.println(powerLikeFac(C, N));
        System.out.println(power(C, N));
    }

    public static int powerLikeFac(int C, int N) {
        if (N == 1)
            return C;
        return powerLikeFac(C, N - 1) * C;
    }

    public static int power(int C, int N) {
        if (N == 1)
            return C;

        // even / odd cases
        if (N % 2 == 0) {
            return power(C, N / 2) * power(C, N / 2);
        } else {
            return power(C, (N - 1) / 2) * power(C, (N - 1) / 2) * C;
        }

    }
}