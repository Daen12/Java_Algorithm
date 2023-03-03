import java.util.Scanner;

class Q2491_수열_silver4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        // 연속해서 커지는 경우
        int total = 0;
        int upward = 1;
        for (int i = 0; i < N - 1; i++) { // 9
            if (arr[i] <= arr[i + 1]) {
                upward++;
                if (i == N - 2) { // 마지막 인덱스이면
                    total = upward > total ? upward : total;
                }
            } else {
                total = upward > total ? upward : total;
                upward = 1;
            }
        }
        // 연속해서 작아지는 경우
        int total2 = 0;
        int downward = 1;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                downward++;
                if (i == N - 2) { // 마지막 인덱스이면
                    total2 = downward > total2 ? downward : total2;
                }
            } else {
                total2 = downward > total2 ? downward : total2;
                downward = 1;
            }
        }
        // 모두 구한다음, Math.max로 더 큰 값 반환
        // 하나의 수가 들어오면 1 출력!
        if (N <= 2) {
            System.out.println(N);
        } else {
            System.out.println(Math.max(total, total2));
        }
    }
}