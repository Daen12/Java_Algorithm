import java.util.Scanner;

public class Q1970_거스름돈_D2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
        int[] count = new int[8];
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int price = in.nextInt();

            // 배열을 돌면서 가격을 나눈 값을 새 배열에 저장.
            // 나눗셈 불가능하면 다음 배열로
            // 가격을 나눈 값은 기존 금액에서 빼고 다음 루프로 이동.

            for (int i = 0; i < 8; i++) {
                if (money[i] > price) {
                    count[i] = 0;
                    continue;
                } else {
                    int countM = price / money[i]; // 3
                    count[i] = countM;
                    price = price - countM * money[i];
                }
            }

            System.out.printf("#%d\n", t);
            for (int c : count) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

    }
}
