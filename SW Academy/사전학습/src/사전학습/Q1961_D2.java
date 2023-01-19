package 사전학습;

import java.util.Arrays;
import java.util.Scanner;

public class Q1961_D2 {
	
	public static String turn(int[][] arr, int dim){
		//for문 하나만?
		for (int j = 0; j < dim; j++) {
			for (int k = 0; k < dim; k++) {
				arr[k][dim - 1 - j] = arr[j][k];
			}
		}
		return Arrays.deepToString(arr);

}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		// num만큼 횟수를 돌면서 계산
		for (int n = 0; n < num; n++) {
			int dimension = in.nextInt();
			int[][] array = new int[dimension][dimension];

			// 루프 돌면서 배열에 값을 담기
			// for루프를 하나만 써보기
			for (int i = 0; i < dimension * dimension; i++) {
				int left = i / 3;
				int right = i % 3;
				array[left][right] = in.nextInt();
			}
			//배열을 90도 뒤집은 값을 first 에 담기
//			System.out.println( Arrays.deepToString(array));
			System.out.println(turn(array, dimension));
			
			
			

		}

	}

}
