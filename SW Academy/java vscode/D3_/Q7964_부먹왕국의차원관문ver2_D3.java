import java.util.Arrays;
import java.util.Scanner;

public class Q7964_부먹왕국의차원관문_D3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = in.nextInt(); // 6
			int[] arr = new int[N + 2]; // 배열에 담기
			int K = in.nextInt(); // 2
			for (int i = 0; i < N + 2; i++) {
				arr[i] = in.nextInt();

			}
			int dist = 0; //거리
			int install = 0; //설치
			for(int i=0; i<N; i++){
				dist++;
				if(arr[i] == 1 || dist>=K){
					if(dist>=K && arr[i]!=0){
						install++;
					}
				}
			}

			System.out.printf("#%d %d\n", t, array[0]);
		}
	}
}
