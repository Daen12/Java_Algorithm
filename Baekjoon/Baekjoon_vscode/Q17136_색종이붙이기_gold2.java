import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q17136_색종이붙이기_gold2 {
	// 1을 만나면 for문으로 1-2-3순으로 색종이 크기 대입
	// 특정 크기로 덮을 때 0이 덮이면 그 전단계의 색종이 +1
	// 덮은 곳은 0으로 바꾸고 나머지 1 헌팅!

	// 인접한 것들안에서 min 카운트
	// 위 과정 같은 번호 안에서 시행 후, 가장 숫자가 작은것을 번호마다 뽑기.
	static boolean[][] visited;
	static int[][] map, copy;
	static int N = 10;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] papers = { 0, 5, 5, 5, 5, 5 };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = in.nextInt();
			}
		}

		visited = new boolean[N][N];
		int n = 1;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited[r][c] && map[r][c] != 0) {// 바다가 아니고 아직 안간 육지이면
					paintGround(r, c, n++);
				}
			}
		}
		for (int[] line : map) {
			System.out.println(Arrays.toString(line));
		}
		int sum = 0;
		visited = new boolean[N][N];
		copy = new int[10][10];
		for (int i = 0; i < 10; i++) {
			copy[i] = map[i].clone();
		}
		for (int i = 1; i < n; i++) {
			// 각번호i가 적힌 부분에 대해 계산 후 합치기
			sum += backTracking(i);
		}
		System.out.println(sum);

	}

	public static int backTracking(int i, int cnt) {// 어느 번호를 볼지 & 쓴 색종이 수
		// i번호가 적힌 면적 최솟값 계산
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == i && copy[r][c] != -1) {
					int num = checkSize(r, c);// 범위 -1로 저장

				}
			}
		}
		return 0;
	}

	// for(int r=0; r<N; r++) {
	// for(int c=0; c<N; c++) {
	// if(map[r][c] == 1 && copy[r][c] !=-1) {//1이고 아직 커버 안했으면
	// int num = checkSize(r,c);//범위 -1로 저장 후 커버
	// papers[num]--;
	// backTracking();
	// for(int i=0; i<10; i++) {//temp -> copy로 원상복구
	// copy[i] = temp[i].clone();
	// }
	//
	// }
	// }
	// }
	// return 0;
	public static int checkSize(int R, int C) {
		for (int i = 5; 1 <= i; i--) {
			outer: for (int r = R; r < R + i; r++) {// 가로세로 i만큼 1이 아니면 break
				for (int c = C; c < C + i; c++) {// 더 작은사이즈 확인
					if (map[r][c] != 1) {
						break outer;
					} else {
						copy[r][c] = -1;
					}
					if (r == R + i - 1 && c == C + i - 1)
						return i;
				}
			}
		}
		return 1;
	}

	public static void paintGround(int R, int C, int n) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { R, C });
		map[R][C] = n;
		visited[R][C] = true;

		while (!queue.isEmpty()) {
			int[] idx = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = idx[0] + dr[d];
				int nc = idx[1] + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				// 인접한 육지이고 아직 방문 안했으면 큐에 넣기.
				if (!visited[nr][nc] && map[nr][nc] != 0) {
					map[nr][nc] = n;
					visited[nr][nc] = true;
					queue.offer(new int[] { nr, nc });
				}
			}
		}
	}

}
