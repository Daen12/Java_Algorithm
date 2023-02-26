package solving_club;

import java.util.Arrays;
import java.util.Scanner;

public class Q7102_준홍이의카드놀이ver2_D3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			
			int N = in.nextInt();
			int M = in.nextInt();
			System.out.print("#"+t+" ");
			int[] arr = new int[N*M];
			//각 카드의 숫자를 하나씩 올려가며 모두 더하기! 브루트포스
					int k =0;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					arr[k++] = i+j;
				}
			}
			//arr을 카운팅소트
			//먼저 최댓값 찾기
			Arrays.sort(arr);
			int max = arr[N*M-1]; //7이면
			int[] count = new int[max+1];
			for(int i=0; i<arr.length; i++) {
				count[arr[i]]++;
			}
//			System.out.println(Arrays.toString(count));
			//count배열의 최댓값 인덱스를 구하기
			int answer = 0;
			int max2 = 0;
			for(int i=0; i<count.length; i++) {
				if(max2<=count[i]) {
					max2 = count[i];
					
				}
			}
			for(int i=0; i<count.length; i++) {
				if(count[i] == max2) {
					System.out.print(i+" ");
				}
			}
		}
	}
	
}
