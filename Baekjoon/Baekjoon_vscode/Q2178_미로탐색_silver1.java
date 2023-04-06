import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2178_미로탐색_silver1 {
	//BFS 
	//클래스에 r,c,cnt저장
	//큐에서 꺼낸 후 사방탐색, 만약 1이고 방문되지 않았으면 큐에 넣은 후 cnt++
	public static class Kan{
		int R,C,cnt;

		public Kan(int r, int c, int cnt) {
			this.R = r;
			this.C = c;
			this.cnt = cnt;
		}
	}
	static int N,M, ans;
	static boolean[][] visited;
	static int[][]map;
	static Queue<Kan> queue;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();//4
		M = in.nextInt();//6
		map = new int[N][M];
		for(int r=0; r<N; r++) {
			String[] line = in.next().split("");
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(line[c]);
			}
		}
//		System.out.println(Arrays.deepToString(map));
		ans = 0;
		BFS();
		System.out.println(ans);
	}
	
	public static void BFS() {
		queue = new LinkedList<>();
		visited = new boolean[N][M];
		queue.offer(new Kan(0,0,1));
		visited[0][0] = true;
		int[] dc = {-1, 0, 1, 0};
		int[] dr = {0,-1, 0,1};
		
		while(!queue.isEmpty()) {
			Kan k = queue.poll();
			for(int d=0; d<4; d++) {
				int nr = k.R + dr[d];
				int nc = k.C + dc[d];
				if(nr < 0 || nc<0 || nr>=N || nc>=M || map[nr][nc] == 0 || visited[nr][nc]) continue;
				visited[nr][nc] = true;
				if(nr == N-1 && nc == M-1) {
					ans = k.cnt + 1;
					break;
				}
//				System.out.println(k.cnt);
				queue.offer(new Kan(nr, nc, k.cnt+1));
			}
		}
		
	}
}
