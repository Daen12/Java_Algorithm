package 사전학습;

import java.util.Arrays;
import java.util.Scanner;

public class Q1204_D2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			//다음 수는 각 테스트케이스의 번호
			int num = sc.nextInt();
			int[] array = new int[101]; //앞의 공백 
			//이후 점수 천개를 각 점수의 인덱스에 저장하기 
			//ex.41수가 나오면 41번째 인덱스에 1추가   
			for(int j=0; j<1000; j++) {
				int idx = sc.nextInt();
				array[idx] = array[idx]+1;
				//array[idx]++;
			}
			//배열에서 가장 큰 수 구하기   
			int max = array[0];
			for(int j=0; j<array.length; j++) {
				if(max<array[j]) max = array[j];
			}
			//////
			for(int t=0; t<array.length; t++) {
				System.out.print(array[t]);
				System.out.print(" ");
			}
			System.out.println("/n");
			System.out.println(max);
			//////
			
//			그 수의 인덱스 출력
//			1. 배열 돌면서 인덱스 구하기
			int index = 100;
			while(array[index] != max) { //2가 답일때 
				index--;
			}
			if(array[index] == max) {
			System.out.println("#"+(num)+" "+index);
			}
			//2. indexOf쓰기  : 문자열로 바꾸면 인덱스는 모든 숫자에 해당되므로 불가능!
//			String str = Arrays.toString(array).replaceAll("[^0-9]", "");
//			int index = str.indexOf(max);
//			System.out.println("#"+(num)+" "+index);
			
			
			
		}

	}

}
