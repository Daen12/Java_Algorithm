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
        findMaxBenefit(1, 0, 0);

        System.out.println(maxIncome);
    }

    public static void findMaxBenefit(int day, int revenue, int prevR) {
        if (day - 1 == N) { // 마지막까지 상담 마침.
            maxIncome = Math.max(revenue, maxIncome);
        }
        if (day >= N) {// 마지막날에 상담 가능하면 그날 비용 더한게 최종비용
            if (day == N && days[N - 1] == 1) {
                revenue = revenue + income[N - 1];
                maxIncome = Math.max(revenue, maxIncome);
            } else if (day == N) { // 마지막날에 상담 불가하면 리턴 (남은 날짜가 최대 날짜보다 많음)
                maxIncome = Math.max(revenue, maxIncome);
            } else {
                maxIncome = Math.max(prevR, maxIncome);
            }
            return;
        }

        for (int i = day; i <= N; i++) {
            // revenue = prevR;
            // 현재 날짜 + 상담일 = 재귀로 넘길 날짜
            // 이익도 마찬가지
            findMaxBenefit(i + days[i - 1], revenue + income[i - 1], revenue);
        }
    }
}
