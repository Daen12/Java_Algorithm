import java.util.Scanner;

public class Q14501_퇴사_silver3 {
    static int N, maxIncome;
    static int[] days, income;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        days = new int[N];
        income = new int[N];
        for (int i = 0; i < N; i++) {
            days[i] = in.nextInt();
            income[i] = in.nextInt();
        }
    }

    // 1 0 0
    // 4 10 0
    // 5 30 10
    // 7 45 30
    public static void findMaxBenefit(int day, int revenue, int prevR) {

        if (day == N) {// 마지막날에 상담 가능하면 그날 비용 더한게 최종비용
            if (days[N - 1] == 1) {
                maxIncome = revenue + income[N - 1];
            } else {
                return;
            }
        } else if (day > N) {
            maxIncome = Math.max(revenue, maxIncome);

        }

        for (int i = day; i < N; i++) {
            // 현재 날짜 + 상담일 = 재귀로 넘길 날짜
            // 이익도 마찬가지
            findMaxBenefit(i + days[i], revenue + income[i], revenue);
        }
    }
}
