package solving_club;

import java.util.Arrays;
import java.util.Scanner;

public class Q1952_수영장 {
	//1-12까지 1,2,3케이스에 대한 중복순열 만들기
	//만들어진 순열배열 X 각 달마다 날짜를 해서 ㅊㅇ합 더하기
	//더해진 값의 최소에 1년 비용을 비교해서 답 산출 (최솟값!)
	static int minCost;
	static int m = 12;
	static int yearly;
	static int[] prices, plans, sel;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=10; t++) {
			prices = new int[3];
			for(int i=0; i<3; i++) {
				prices[i] = in.nextInt();
			}
			yearly = in.nextInt();
			
			plans = new int[m];
			for(int i=0; i<m; i++) {
				plans[i] = in.nextInt();
			}//input plans
			
			sel = new int[m];
			minCost = Integer.MAX_VALUE;
			dfs(0, minCost, 0, 0);
			
			
			System.out.printf("#%d %d\n", t, minCost);
		}
		
	}
	public static void dfs(int depth, int cost, int cnt, int three) {//cost는 이전까지 누적된 비용
		if(cost > yearly) {
			minCost = Math.min(minCost, yearly);
			return;//연간권보다 높아지면 리턴
		}
		
		if(depth == m) {//12개의 중복순열 생성 시
//			for(int i=0; i<m; i++) {
//				System.out.print(sel[i] + " ");
//			}
//			System.out.println();
//			System.out.println(cost);
			minCost = Math.min(minCost, cost);
			return;
		}
		for(int i=0; i<3; i++) {
			sel[depth] = prices[i];//갱신된 sel값
			
			int addcost = 0;//더해줄 cost 계산
			if(i==0) {
				addcost = plans[depth]*sel[depth];
				cnt = 0;
			} else if(i ==1) {
				addcost = sel[depth];
				cnt = 0;
			} else {//2일때
				if(cnt==3) {
					addcost = three+sel[depth];//3개월전+3월권
				} else {
					if(cnt==0) {//처음 2이면
						cnt++;
						three=cost;
					} else {
						cnt++;
					}
				}
			}
			dfs(depth+1, cost+addcost, cnt, three);
		}
	}
}
