package 사전학습;

import java.util.Scanner;

public class Q2068_D1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i=0; i<num; i++) {
			//배열화를 한다면 sort후에 9번째 인덱스를 뽑아내는 방법이 좋음.
//			int[] array = new int[10];
//			for(int j=0;j<10;j++) {
//				array[j] = sc.nextInt();
//			}
			//array에서 최댓값 구하기
			int max = 0;
			for(int j=0; j<10; j++) {
				int number = sc.nextInt();
				if(number>max) {
					max = number;
				}
			}
			System.out.println("#"+(i+1)+" "+max);
			
		}

	}

}
