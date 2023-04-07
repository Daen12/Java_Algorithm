import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q17136_색종이붙이기2_gold2 {
	// https://steady-coding.tistory.com/43

	static int[][] map;
	static int N = 10;
	static int minCount;
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
		// visited = new boolean[N][N]; //색종이 붙였다 뗐다 하면서 전체 갯수 카운트 해주기때문에 방문체크 필요없음.
		minCount = Integer.MAX_VALUE;
		backTracking(0, 0, 0);
		if (minCount == Integer.MAX_VALUE) {
			minCount = -1;
		}
		System.out.println(minCount);
	}

	public static void backTracking(int R, int C, int cnt) {// 어느 인덱스를 볼지 & 쓴 색종이 수
		// 만약 배열의 끝에 도달했으면 색종이 다 채운것.
		// 카운트 최솟값 갱신
		if (R == 9 && C == 10) {
			minCount = Math.min(minCount, cnt);
		}
		// 색종이 합이 기존 합과 같거나 많으면 리턴
		if (cnt >= minCount)
			return;

		// 옆으로 이동 못하면 아래줄로 이동
		if (C == 10) {
			backTracking(R + 1, 0, cnt);
			return;
		}

		if (map[R][C] == 1) {
			for (int i = 5; 1 <= i; i--) {
				// 만약에 해당 자리에 i만큼 색종이를 붙일 수 있고 & 붙일 색종이가 남아있으면
				if (papers[i] > 0 && checkSize(R, C, i)) {
					// 붙이고
					attach(R, C, i, 0);
					// 색종이배열에서 한칸 빼주기
					papers[i]--;
					// cnt+1한거 DFS - 옆칸으로 넘어가서 실행
					backTracking(R, C + 1, cnt + 1);
					// 다시 색종이 배열 원상복구
					attach(R, C, i, 1);
					// 붙인거 떼기
					papers[i]++;
				}
			}
		} else {
			backTracking(R, C + 1, cnt);
		}

	}

	public static void attach(int R, int C, int i, int num) {
		for (int r = R; r < R + i; r++) {
			for (int c = C; c < C + i; c++) {
				map[r][c] = num;
			}
		}
	}

	public static boolean checkSize(int R, int C, int i) {
		for (int r = R; r < R + i; r++) {
			for (int c = C; c < C + i; c++) {
				if (r >= 10 || c >= 10)
					return false;
				if (map[r][c] != 1)
					return false;
			}
		}
		return true;
	}
}
