package solving_club;

import java.util.Scanner;

public class Q5215_�ܹ��Ŵ��̾�Ʈ_D3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			int N = in.nextInt(); //5
			int L = in.nextInt(); //1000 calorie limit
			
			int[] score = new int[N];
			int[] calorie = new int[N];
			int maxScore = 0;
			for(int i=0; i<N; i++) {
				score[i] = in.nextInt();
				calorie[i] = in.nextInt();
			}
			
			for(int i=0; i<(1<<N); i++) {//��� ������ ���. ���ÿ����� 32��
				int totalCal = 0;
				int totalScore = 0;
				for(int j=0; j<N; j++) { //�� �ε����� ��ᰡ ������
					if((i & (1<<j)) > 0) { //��ġ�� ��ᰡ ������
						totalCal += calorie[j];
						totalScore += score[j];
					}
				}
				//��� ���� round ��
				//���� Į�θ��� limit�� ���� �ʴ´ٸ� �ش� ���ھ max���� ū�� Ȯ��, ũ�� swap
				if(totalCal <= L) {
					maxScore = maxScore < totalScore? totalScore : maxScore;
				}
			}
			System.out.printf("#%d %d\n", t, maxScore);
		}
	}
}
