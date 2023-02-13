package day0206_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q5215 {
	
	
	//DFS??
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		int N = in.nextInt();
		int L = in.nextInt();
		
		//N크기에 각각2크기가 들어가는 이중배열 만들기
		//info[0] = score, info[1] = calorie
		int[][] info = new int[N][2];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<2; j++) {
				info[i][j] = in.nextInt();
			}
		}
		
		//점수만 있는 배열
		int[] scores = new int[N];
		for(int i=0; i<N; i++) {
			scores[i] = info[i][0];
		}
		System.out.println(Arrays.toString(scores));
		//칼로리만 있는 배열
		int[] calories = new int[N];
		for(int i=0; i<N; i++) {
			calories[i] = info[i][1];
		}
		System.out.println(Arrays.toString(calories));
		
		//칼로리 순서대로 정렬하기
		for(int j =0; j<N; j++) {
			for(int i=0; i<N-1; i++) {
				if(info[i][1]<info[i+1][1]) {
					int[] temp = new int[2];
					temp = info[i];
					info[i] = info[i+1];
					info[i+1] = temp;
				};
			}
		}
		System.out.println(Arrays.deepToString(info));
		//각각의 n 자리에 대하여 점수가 들어갈 배열을 생성한다.
		int[] scoreArray = new int[N];
		for(int i=0; i<N; i++) {
			int score = 0;
			if(L-info[i][1] >= 0) {
				int leftCalorie = L-info[i][1];
				int round = 1;
				score+=info[i][1];
				round++;
				//더이상 1000에서 뺄 수 없으면
				while(leftCalorie<info[i+round][1] && round<=N-i) {
					++round;
				}
				
				while(leftCalorie>info[i+round][1]) {
					score+=info[i+round][1];
					leftCalorie = leftCalorie - info[i+round][1];
					++round;
				}
			}
			scoreArray[i] = score;
		}
		System.out.print(Arrays.toString(scoreArray));
	}
}
