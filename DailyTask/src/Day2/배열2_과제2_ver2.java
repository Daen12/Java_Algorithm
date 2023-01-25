package Day2;

import java.util.Scanner;

public class 배열2_과제2_ver2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// n * n 크기 배열 선언 ( 지도 )
		int[][] map = new int[n][n];
		
		// 지도 정보 입력 받기
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		// 최대값 저장
		int maxDistance = 0;
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				// 지금 위치가 섬인지 검사   
				if(map[r][c] == 1) {
					//섬이면 사방 탐색하여 거리측정, 최대값 저장
					
					//동쪽이 1인지 검사
					//오른쪽으로 이동해야하므로 전체길이 n에서 현재 위치만큼 뺀 거리까지 
					for(int d=1; d<n-c; d++) {
						//1을 만나면 섬이므로 break
						if(map[r][c+d] == 1) {
							maxDistance = Math.max(maxDistance, d);
							break;
						}
					}
					//서쪽이 1인지 검사
					//왼쪽으로 이동해야하므로 현재 위치까지만 이동 가능.
					for(int d=1; d<=c; d++) {
						//1을 만나면 섬이므로 break
						if(map[r][c-d] == 1) {
							maxDistance = Math.max(maxDistance, d);
							break;
						}
					}
					//남쪽이 1인지 검사
					//아래로 R을 이동해야하므로 전체길이 n에서 r을 뺀 거리까지 
					for(int d=1; d<n-r; d++) {
						//1을 만나면 섬이므로 break
						if(map[r+d][c] == 1) {
							maxDistance = Math.max(maxDistance, d);
							break;
						}
					}
					//북쪽이 1인지 검사
					//위로 이동해야하므로 현재 위치만큼만 이동 가능.  
					for(int d=1; d<=r; d++) {
						//1을 만나면 섬이므로 break
						if(map[r-d][c] == 1) {
							maxDistance = Math.max(maxDistance, d);
							break;
						}
					}
					
				}
			}
		}
		System.out.println(maxDistance);
	}
}
