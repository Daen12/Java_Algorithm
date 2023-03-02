package solving_club;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q4613_러시아국기ver2_D4 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken()); //4
			int C = Integer.parseInt(st.nextToken()); //5
			String[] inputs = new String[R];
			for(int i=0; i<R; i++) {
				inputs[i] = br.readLine();
			}
			// W B R이 될수있는 모든 순열의 수
			int a = 1;
			int b = R - 2;
			int min = Integer.MAX_VALUE;
			for (int i = a; i <= b; i++) {
				for (int j = a; j <= b; j++) {
					for (int k = a; k <= b; k++) {
						// 만약 i+j+k = 4이라면 채택
						if (i + j + k == R) {
							// color 배열을 해당 색깔로 채우기
							char[] colors = new char[R]; //[W,B,R,R]
							Arrays.fill(colors, 0, i, 'W');
							Arrays.fill(colors, i, j + i, 'B');
							Arrays.fill(colors, i + j, R, 'R');
							int count = 0;//바꿔야 하는 단어의 개수
							for (int r = 0; r < R; r++) { // 각 row마다
								// 각 색깔 개수 세기
								int white = (int) inputs[r].chars().filter(c -> c == 'W').count();
								int red = (int) inputs[r].chars().filter(c -> c == 'R').count();
								int blue = (int) inputs[r].chars().filter(c -> c == 'B').count();

								if (colors[r] == 'W') {
									count += (red+blue);
								}
								if (colors[r] == 'B') {
									count += (red+white);
								}
								if (colors[r] == 'R') {
									count += (white+blue);
								}
							}
							//포문 다돌고 count를 비교하기
							if(min>count) {
								min = count;
							}
						}
					}
				}
			}
			System.out.println("#"+t+" "+min);
		}
	}
}
