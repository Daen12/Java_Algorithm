import java.util.Scanner;
import java.util.Stack;

public class Q5215_햄버거다이어트_D3 {
	//부분집합 
	//리턴조건 = 정해진 칼로리보다 높을때
	//i는 재료의 인덱스. 맛 점수 더해가기
	static int N, L, Max;
	static int[] taste, cal;
	static Stack<Integer> stack;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T= in.nextInt();
		for(int t=1; t<=T; t++) {
			N = in.nextInt();
			L = in.nextInt();
			taste = new int[N];
			cal = new int[N];
			for(int i=0; i<N; i++) {
				taste[i] = in.nextInt();
				cal[i] = in.nextInt();
			}
			stack = new Stack<>();
			Max = -1;
			powerSet(0, 0);
			
			System.out.printf("#%d %d\n", t, Max);
		}
	}
	
	public static void powerSet(int depth, int calorie) {
		if(calorie > L) return;
		if(depth == N) {//깊이가 N일때
			int sum = 0;
			for(int s : stack) {
				//맛 누적합 구하기
				sum+=taste[s];
			}
			Max = Math.max(Max, sum);
			return;
		}
		stack.push(depth);
		powerSet(depth+1, calorie+cal[depth]);
		stack.pop();
		powerSet(depth+1, calorie);
	}
}
