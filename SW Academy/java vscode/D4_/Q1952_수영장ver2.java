package solving_club;

import java.util.Arrays;
import java.util.Scanner;

public class Q1952_수영장ver2 {
	//feat.호진's 코드
	
	static int minCost;
	static int m = 12;
	static int yearly;
	static int[] prices, plans, sel;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			prices = new int[3];
			for (int i = 0; i < 3; i++) {
				prices[i] = in.nextInt();
			}
			yearly = in.nextInt();

			plans = new int[m];// index ranges from 0 to 11
			for (int i = 0; i < m; i++) {
				plans[i] = in.nextInt();
			} // input plans

			sel = new int[m];
			minCost = Integer.MAX_VALUE;
			dfs(0, 0);

			System.out.printf("#%d %d\n", t, minCost);
		}
	}


	public static void dfs(int mon, int cost) {// cost는 이전까지 누적된 비용
		if(cost> minCost) {//최소비용보다 더 쌓이면 리턴
			return;
		}
		if(cost > yearly) {//연간권보다 높으면 연간권 비용이 최소
			minCost = Math.min(minCost, yearly);
		}
		if (mon >= m) {
//			System.out.println("여기오니?"); //여기 오기 전에 리턴되는 케이스가 있음!
			minCost = Math.min(minCost, cost);
			return;// 12월을 넘어서면 최소비용 계산 후 리턴
		}
//		if(plans[mon] == 0) {
//			dfs(mon+1, cost);
//		} else {
			dfs(mon + 1, cost + plans[mon] * prices[0]);
			dfs(mon + 1, cost + prices[1]);
			dfs(mon + 3, cost + prices[2]);
			
//		}

	}
}
