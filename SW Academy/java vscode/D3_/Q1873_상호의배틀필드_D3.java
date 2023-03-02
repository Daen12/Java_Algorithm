package solving_club;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1873_상호의배틀필드_D3 {
	static int R;
	static int C;
	static int H;
	static int W;
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for (int r = 0; r < H; r++) {
				char[] line = br.readLine().toCharArray();
				for (int c = 0; c < W; c++) {
					map[r][c] = line[c];
					if (map[r][c] == '^' || map[r][c] == 'v' || map[r][c] == '<' || map[r][c] == '>') {
						R = r;
						C = c; // 전차의 좌표 저장!
					}
				}
			} // 입력!

			int cNum = Integer.parseInt(br.readLine());
			char[] commands = br.readLine().toCharArray();
			for (int c = 0; c < cNum; c++) {
				switch (commands[c]) {
				case 'U':
					U();
					break;
				case 'D':
					D();
					break;
				case 'L':
					L();
					break;
				case 'R':
					R();
					break;
				case 'S':
					S();
					break;
				}
			}

			System.out.print("#" + t + " ");
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					System.out.print(map[r][c]);
				}
				System.out.println();
			}
		}
	}
	public static void U() {
		map[R][C] = '^';
		if(R-1>=0 && map[R-1][C] == '.') {
			map[R-1][C] = '^';
			map[R][C] = '.';
			R = R-1;
		}
	}
	public static void D() {
		map[R][C] = 'v';
		if(R+1<H && map[R+1][C] == '.') {
			map[R+1][C] = 'v';
			map[R][C] = '.';
			R = R+1;
		}
	}
	public static void L() {
		map[R][C] = '<';
		if(C-1>=0 && map[R][C-1] == '.') {
			map[R][C-1] = '<';
			map[R][C] = '.';
			C = C-1;
		}
	}
	public static void R() {
		map[R][C] = '>';
		if(C+1<W && map[R][C+1] == '.') {
			map[R][C+1] = '>';
			map[R][C] = '.';
			C = C+1;
		}
	}
	public static void S() { //벽돌이 평지가 되는 상황만 연산
		int nr = R;
		int nc = C;
		
		if(map[R][C] == '<') { //왼쪽
			while(nc>=0) {
				if(map[nr][nc] == '#') {
					break;
				} else if(map[nr][nc] == '*') {
					map[nr][nc] = '.';
					break;
				}
				nc--;
			}
		}
		if(map[R][C] == '>') { //오른쪽
			while(nc<W) {
				if(map[nr][nc] == '#') {
					break;
				} else if(map[nr][nc] == '*') {
					map[nr][nc] = '.';
					break;
				}
				nc++;
			}
		}
		if(map[R][C] == '^') { //위쪽
			while(0<=nr) {
				if(map[nr][nc] == '#') {
					break;
				} else if(map[nr][nc] == '*') {
					map[nr][nc] = '.';
					break;
				}
				nr--;
			}
		}
		if(map[R][C] == 'v') { //위쪽
			while(nr<H) {
				if(map[nr][nc] == '#') {
					break;
				} else if(map[nr][nc] == '*') {
					map[nr][nc] = '.';
					break;
				}
				nr++;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
