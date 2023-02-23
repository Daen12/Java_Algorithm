
import java.util.Arrays;
import java.util.Scanner;

public class Q3985_롤케이크_bronze1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int L = in.nextInt();
		// 케이크 배열 만들기
		int[] cake = new int[L+1]; //10
		int T = in.nextInt(); //3
		int[][] index = new int[T][2]; // {{2,4}, {7,8}, {6,9}}
		// 입력받은 인덱스 이중배열에 저장
		// 인덱스 차가 가장 큰 사람이 첫번째 답.
		int first = 0;
		int max = 0;
		for (int i = 0; i < T; i++) {
			index[i][0] = in.nextInt();
			index[i][1] = in.nextInt();
			if (index[i][1] - index[i][0] > max) {
				max = index[i][1] - index[i][0];
				first = i + 1;
			}
		}
		int second = 0;
		// 뒤에서부터
		for (int t = T - 1; 0 <= t; t--) {
			Arrays.fill(cake, index[t][0], index[t][1] + 1, t + 1);
		}
		// cake배열을 카운트소트
		int[] count = new int[T + 1]; //4
		for (int i = 0; i < L; i++) {
			count[cake[i]]++;
		}
		int max2 = 0;
		for (int i = 1; i <= T; i++) {
			if (count[i] > max2) {
				max2 = count[i];
				second = i;
			}
		}
		System.out.println(first);
		System.out.println(second);
	}
}
