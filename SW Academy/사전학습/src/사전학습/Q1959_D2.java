package 사전학습;

import java.util.Scanner;

public class Q1959_D2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i=0; i<num; i++) {
			
			int firstnum = sc.nextInt(); //3
			int secondnum = sc.nextInt(); //5
			int[] array1 = new int[firstnum];
			int[] array2 = new int[secondnum];
			
			for(int j=0; j<firstnum; j++) {//0,1,2(nonTarget)
				//여기다가 첫번째 배열 넣고
				array1[j] = sc.nextInt();
			}
			for(int j=0; j<secondnum; j++) {//0,1,2,3,4(target)
				//여기다가 두번째 배열 넣고
				array2[j] = sc.nextInt();
			}
			//길이가 더 긴 배열이 target 배열이 됨.
			int[] target = firstnum<secondnum? array2 : array1;
			int[] nonTarget = firstnum<secondnum? array1 : array2;
				
			//몇번 옮길 수 있는지 계산
			int shift = (Math.abs(firstnum - secondnum)) + 1; 
			//계산값(3개)이 들어갈 배열 만들기
			int count = 0;
			int[] sumList = new int[shift];
			while(count<shift) {
			int sum = 0;
			for(int k=0; k<nonTarget.length; k++) {//k=0,1,2
				sum+= nonTarget[k] * target[k+count];
			}
			sumList[count] = sum;
			count++;
			}
			
			int max=0;
			for(int t=0; t<shift; t++) {
				max = sumList[t]>max? sumList[t] : max;
			}
//			int[] sorted = Arrays.sort(sumList); //sumList를 오름차순으
//			int max = sorted[shift-1];
			System.out.println("#"+(i+1)+" "+max);
			
		}

	}

}
