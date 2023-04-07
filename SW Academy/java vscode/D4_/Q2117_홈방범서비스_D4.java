import java.util.Scanner;

public class Q2117_홈방범서비스_D4 {
	//손해를 보지 않는다 = 비용 < 수익 
	//서비스 받는 집의 수 출력 
	//K = 1 ~ 면적 뒤덮는 최댓값까지 가능?
	static int[][] map, cover;
	static int N,M;
	static int cnt, maxCnt;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T= in.nextInt();
		int home = 0;
		for(int t=1 ;t<=T; t++) {
			N = in.nextInt();
			M = in.nextInt();//한 집이 지불할 비용
			map = new int[N][N];
			cover = new int[N][N];
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					map[r][c] = in.nextInt();
					if(map[r][c] == 1) home++;
				}
			}
//			int maxK = (home*M+1)/4;
			maxCnt = 0;
			//k는 1부터 maxK까지 가능
			for(int k=1; k<=22; k++) {
				int cost = (int) (Math.pow(k, 2) + Math.pow(k-1, 2));
				for(int r=0; r<N; r++) {
					for(int c=0; c<N; c++) {
						cover = new int[N][N];
						paintCover(r,c,k);//범위를 지정한 후
						//그 안에 집이 있으면 
						cnt = 0;
						if(cost<=pay()) {
							maxCnt = Math.max(maxCnt, cnt);
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, maxCnt);
		}
	}
	public static int pay() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(cover[r][c] == 1 && map[r][c]==1) {
					cnt++;
				}
			}
		}
		return cnt *M;
	}
	public static void paintCover(int R, int C, int k) {
		//중심이 r,c이고 크기가 K인 map
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(distance(R,C,r,c)<k) {
					cover[r][c] = 1;
				}
			}
		}
	}
	public static int distance(int R, int C, int r, int c) {
		return Math.abs(R - r) + Math.abs(C - c);
	}
}
