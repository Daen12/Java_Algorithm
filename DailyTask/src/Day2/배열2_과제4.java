package Day2;

import java.util.Scanner;
import java.util.Arrays;

public class 배열2_과제4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		// map 구성하기
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		// 각 인덱스를 돌면서 가로,세로,높이의 합 구해서 배열에 저장하기.
		int[][] maxList = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int webTotal = 0;
				// 팔방 검사
				int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
				int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
				for (int j = 0; j < 8; j++) {
					// 각 방향에 대하여
					// 다음 인덱스를 저장해주고
					int nr1 = r + dr[j];
					int nc1 = c + dc[j];
					// 다다음 인덱스 저장
					int nr2 = nr1 + dr[j];
					int nc2 = nc1 + dc[j];
					// 새로운 인덱스의 자리가 MAP을 벗어나지 않는 동안, while루프
					while (nr2 >= 0 && nc2 >= 0 && nr2 < N && nc2 < N) {
						if (map[nr1][nc1] == 0)
							webTotal++;
						if(map[nr2][nc2] == 1 && map[nr1][nc1]==1) break;
						//다음 인덱스
						nr1 = nr1 + dr[j];
						nc1 = nc1 + dc[j];
						//다다음 인덱스
						nr2 = nr1 + dr[j];
						nc2 = nc1 + dc[j];
					}
					//while루프 안돌았을때 예외처리
					if (nr1 < 0 || nc1 < 0 || nr1 >= N || nc1 >= N)
						continue;
					//위에서 nr2를 기준으로 예외처리 했으므로 nr1을 한번 더 체크하기
					if(map[nr1][nc1] == 0) webTotal++;
				}
				//만약 자신이 0이면 하나 더한 후 maxList에 더하기
				maxList[r][c] = map[r][c] == 0? webTotal+1 : webTotal;
			}
		}
		int maxNum = 0;
		int R = -1;
		int C = -1;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(maxNum<maxList[r][c]){
					maxNum = maxList[r][c];
					R = r;
					C = c;
				}
			}
		}
		System.out.println(maxNum);
		System.out.println(R + ", "+C);

		

		
	}

}

