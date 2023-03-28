package solving_club;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q1226_미로1_D4 {
	static boolean[][] visited;
	static int[][] graph;
	static Stack<Integer> stack = new Stack<>();
	static int N, goalR, goalC, result;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = 16;
		for(int t=1; t<=10; t++) {
			int tc = in.nextInt();
			graph = new int[N][N];
			for(int r=0; r<N; r++) {
				String[] line = in.next().split("");
				for(int c=0; c<N; c++) {
					graph[r][c] = Integer.parseInt(line[c]);
					if(graph[r][c] == 3) {
						goalR = r;
						goalC =c;
					}
				}
			}
			visited = new boolean[N][N];
			result = 0;
			DFS(1,1);//출발인덱스
			System.out.printf("#%d %d\n", t, result);
		}
	}
	
	static void DFS(int R, int C) {
		//방문처리
		visited[R][C] = true;
//		System.out.print(v+1+" ");//그래프v가 0부터 시작.
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		//r,c를 기준으로 4방향 탐색. 
		//만약 다음좌표가 이동가능하면 DFS(nr, nc)
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				for(int d=0; d<4; d++) {
					int nr = R + dr[d];
					int nc = C + dc[d];
					if(nr<0 || nr>=16 || nc<0 || nc>=16)//범위 체크
						continue;
					if(graph[nr][nc] == 3) result = 1;
					if(!visited[nr][nc] && graph[nr][nc] == 0) {
						//방문하지 않았으면서 길이 있으면
						graph[nr][nc] = 9;
						DFS(nr,nc);
					}
				}
			}
		}
	}

}
