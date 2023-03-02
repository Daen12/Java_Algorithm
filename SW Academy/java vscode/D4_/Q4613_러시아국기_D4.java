package solving_club;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4613_러시아국기_D4 {
	public static void main(String[] args) throws IOException {
		// 해당 줄에 W가 우세하면
		// 밑에 2줄 이상 남아있으면 w로 칠하기 c <= N-2
		// B가 우세 -> 밑에 1줄 이상 남아있으면 칠하기 c<=N-1
		// R가 우세 -> 노상관
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			String[] flag = new String[C];
			int f = 0;
			int count = 0;
			for (int i = 0; i < R; i++) { // 각 row마다
				flag[f++] = "W";

				String input = br.readLine();
				// 각 색깔 개수 세고 최대 개수 구하기
				int white = (int) input.chars().filter(c -> c == 'W').count();
				int red = (int) input.chars().filter(c -> c == 'R').count();
				int blue = (int) input.chars().filter(c -> c == 'B').count();
				int max = 0;
				int[] maxCheck = { white, red, blue };
				for (int m = 0; m < 3; m++) {
					if (max < maxCheck[i]) {
						max = maxCheck[i];
					}
				}
				;
				// 첫줄은 무조건 w로 채워주기
				if (i == 0) {
					count += C - white;
				} else {
					if (max == white) {
						
					}
				}
				// 만약 최대 개수가 white 이면
				// 위에 다른 색깔이 없으면 C에서 white 뺀 수만큼 카운트하기
				// 위에 다른 색깔 있으면

				// 만약 다음 최대 개수가 blue이면
				//
			}
		}

	}
}
