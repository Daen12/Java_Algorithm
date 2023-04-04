import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q1953_탈주범검거 {
	static int R,C,M,N,time,cnt;
	static int[][]map;
	static boolean[][] added;
	static Queue<Integer> queue;
	//상,하,좌,우
	static int[] dc = {0,0,-1,1};
	static int[] dr = {-1,1,0,0};
	static int[][] search = {{}, {0,1,2,3}, {0,1},{2,3},{0,3},{1,3},{1,2},{0,2}};
	static int[][] dir = {{1,2,5,6},{1,2,4,7},{1,3,4,5},{1,3,6,7}};
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			N = in.nextInt();//세로크기
			M = in.nextInt();//가로크기
			R = in.nextInt();//맨홀의 세로위치
			C = in.nextInt();//가로위치
			time = in.nextInt();
			
			map = new int[N][M];
			added = new boolean[N][M];
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					map[r][c] = in.nextInt();
				}
			}//map저장 완료
			BFS();
			
			int ans = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(added[r][c] == true) ans++;
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}

	private static void BFS() {
		queue = new LinkedList<Integer>();
		queue.offer(R);
		queue.offer(C);
		queue.offer(1);
		added[R][C] = true;
		
		outer : while(!queue.isEmpty()) {
			int r = queue.poll();//한쌍에 두개
			int c = queue.poll();
			int cnt = queue.poll();
			
			if(cnt+1>time)break;
			
			int val = map[r][c];
			//터널 모양에 따라 사방중 어디 탐색할지 정하기
			for(int i=0; i<search[val].length; i++) {
				int nr = r + dr[search[val][i]];//새로운 좌표
				int nc = c + dc[search[val][i]];
				if(nr<0 || nc< 0 || nr>=N || nc>=M) continue;
				//원점에서부터의 거리 = 범위
//				int far = Math.abs(R - nr) + Math.abs(C - nc);
//				System.out.println("far : "+far);
//				if(far+1>time) {
//					break outer;
//				}
				//search[val][i] = 방향. 0이면 위로 
				int direction = search[val][i];
				for(int j=0; j<dir[direction].length; j++) {
					if(map[nr][nc] == dir[direction][j] && !added[nr][nc]) {//그 방향으로 갈수있는 파이프이면 
						queue.offer(nr);//큐에 넣기
						queue.offer(nc);
						queue.offer(cnt+1);
						added[nr][nc] = true;
					}
				}
			}
		}
	}
	
	
//	
//	public static void start() {
//		System.out.println(cnt);
//		if(cnt > time) return;
//		int val = map[R][C];
//		added[R][C] = true;
//		switch(val) {
//		case 1 :
//			//상하좌우
//			up();
//			down();
//			left();
//			right();
//			break;
//		case 2 :
//			//상하
//			up();
//			down();
//			break;
//		case 3 : 
//			//좌,우
//			left();
//			right();
//			break;
//		case 4 :
//			//상,우
//			up();
//			right();
//		case 5 : 
//			down();
//			right();
//			break;
//		case 6 : 
//			down();
//			left();
//			break;
//		case 7 :
//			up();
//			left();
//			break;
//		}
//	}
//	public static void up() {
//		if(R-1<0) {//범위 벗어나면 리턴
//			return;
//		}else {
//			int val = map[R][C];
//			if(val==1 || val ==2 || val==5 || val ==6) {
//				R--;//위로 올라가고
//				if(added[R][C]==false) added[R][C] = true;//true로 갱신
//				cnt++;
//				start();
//				return;
//			}
//		}
//		return;
//	}
//	public static void down() {
//		if(N<=R+1) {//범위 벗어나면 리턴
//			return;
//		}else {
//			int val = map[R][C];
//			if(val==1 || val ==2 || val==4 || val==7) {
//				R++;
//				if(added[R][C]==false) added[R][C] = true;//true로 갱신
//				cnt++;
//				start();
//				return;
//			}
//		}
//		return;
//	}
//	public static void left() {
//		if(C-1<0) {//범위 벗어나면 리턴
//			return;
//		}else {
//			int val = map[R][C];
//			if(val==1 || val ==3 || val==4 || val==5) {
//				C--;
//				if(added[R][C]==false) added[R][C] = true;//true로 갱신
//				cnt++;
//				start();
////				return;
//			}
//		}
////		return;
//	}
//	public static void right() {
//		if(M<=C+1) {//범위 벗어나면 리턴
//			return;
//		}else {
//			int val = map[R][C];
//			if(val==1 || val ==3 || val==6 || val==7) {
//				C++;
//				if(added[R][C]==false) added[R][C] = true;//true로 갱신
//				cnt++;
//				start();
////				return;
//			}
//		}
////		return;
//	}
}
