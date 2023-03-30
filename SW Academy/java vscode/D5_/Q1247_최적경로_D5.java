import java.util.Scanner;

public class Q1247_최적경로_D5 {
	
	//회사, 집, N명의 고객 
	//각 좌표는 (x,y)
	//모두 방문하고 집에 돌아갈때 이동거리가 최소여야 함.
	//순열문제!
	static int min;
	static boolean[] isUsed;
	static point home, comp;
	static point[] temp;
	static point[] customers; 
	static int N;
	
	static class point{
		int x,y;
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			N =  in.nextInt();
			//회사의 좌표
			comp = new point(in.nextInt(), in.nextInt());
			//집의 좌표
			home = new point(in.nextInt(), in.nextInt());
			//고객의 좌표
			customers = new point[N];
			for(int i=0; i<N; i++) {
				customers[i] = new point(in.nextInt(), in.nextInt());
			}
			temp = new point[N];
			min = Integer.MAX_VALUE;
			isUsed = new boolean[N];
			Permutation(0);
			System.out.printf("#%d %d\n", t, min);
		}
	}
	public static void Permutation(int depth) {
		if(depth == N) {
			//temp의 좌표를 하나씩 꺼내서 거리 계산하기 
			int sum = 0;
			sum+=(Math.abs(comp.x - temp[0].x) + Math.abs(comp.y-temp[0].y));
			sum+=(Math.abs(temp[N-1].x - home.x) + Math.abs(temp[N-1].y - home.y));
			for(int i=0; i<N-1; i++) {
				sum+=(Math.abs(temp[i].x - temp[i+1].x) + Math.abs(temp[i].y - temp[i+1].y));
			}
			//sum과 max 값 비교하여 갱신
			min = Math.min(min, sum);
			
		}
		for(int i=0; i<N; i++) {
			if(!isUsed[i]) {
				isUsed[i] = true;
				temp[depth] = customers[i];
				Permutation(depth+1);
				isUsed[i] = false;
			}
		}
		
	}
	
}
