import java.util.Scanner;

public class Q1247_최적경로ver2_D5 {
	
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
			Permutation(0, comp.x, comp.y, 0);
			System.out.printf("#%d %d\n", t, min);
		}
	}
	
	//앞의 prev들에는 현재 더하는 고객의 좌표를 저장하여
	//다음 재귀에서 사용 할 수 있게 하는 용도
	//dist에는 거리를 누적 저장. 이때 재귀를 다시 타고 올라올 시 그전의 distance로 계산되어 모든 케이스 확인 가능함.
	public static void Permutation(int depth, int prevX, int prevY, int dist) {
		if(depth == N) {
			//집까지의 거리 추가 계산
			dist+= distance(prevX, prevY, home.x, home.y);
			//sum과 max 값 비교하여 갱신
			min = Math.min(min, dist);
			
		}
		for(int i=0; i<N; i++) {
			if(!isUsed[i]) {
				isUsed[i] = true;
				Permutation(depth+1, customers[i].x, customers[i].y, dist+distance(prevX, prevY, customers[i].x, customers[i].y));
				isUsed[i] = false;
			}
		}
	}
	public static int distance(int prevX, int prevY, int thisX, int thisY) {//거리계산
		return Math.abs(prevX-thisX) + Math.abs(prevY-thisY);
	}
	
}
