package solving_club;

import java.util.Scanner;

public class Q1733_J_오목 {
	static int[][] map;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		map = new int[19][19];
		for(int r=0; r<19; r++) {
			for(int c=0; c<19; c++) {
				map[r][c] = in.nextInt();
			}
		}
		//입력
		//왼쪽위에서 오른쪽아래로 scan.
		for(int r=0; r<19; r++) {
			for(int c=0; c<19; c++) {
				if(map[r][c]==1) {
					if(checkOmok(r,c,1)) {
						System.out.println(1);
						System.out.print(r+" "+c);
					};
				}
				if(map[r][c]==2) {
					if(checkOmok(r,c,2)) {
						System.out.println(1);
						System.out.print(r+" "+c);
					}
				}
			}
		}
	}
	public static boolean checkOmok(int r, int c, int N) {
		int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
		int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
		
		for(int i=0; i<8; i++) {//각 방향에 대해서 
			int k = 1;
			int nr = r+dr[i];
			int nc = c + dc[i];
			if(nr<0 || nr>19 || nc<0 || nc>19) continue;
			while(map[nr][nc] == N) {//방향이 맞으면 그방향으로 계속 가기
				nr = r+(dr[i]*++k);
				nc = r+(dc[i]*++k);
				if(nr<0 || nr>19 || nc<0 || nc>19) break;
			}
			//N이 아니면 탈출.
			if(k==5) return true;
		}
		return false;
	}
	
}
