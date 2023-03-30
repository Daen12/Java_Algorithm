package solving_club;

import java.util.Arrays;
import java.util.Scanner;

public class Q6808_규영이와인영이의카드게임_D3 {
	//인영이가 내는 카드의 순서에 따라 = 9!
	//인영카드의 순열조합을 구한 후 
	//각각 비교해서 총점 구하기 - 같으면 무승부
	
	//순열은 isUsed 불리언배열 활용
	//
	
	static int[] Kcards = new int[9];
	static int[] Icards = new int[9];
	static int[] scenario;
	static int lose, win;
	static boolean[] isUsed;
	
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		int T = in.nextInt();
		
		for(int t=1; t<=T; t++) {//각 테케에 대해서
			//규영카드저장.
			for(int i=0; i<9; i++) {
				Kcards[i] = in.nextInt();
			}
			//인영카드 저장.
			int iIdx = 0;
			for(int j=1; j<=18; j++) {
				boolean isKcard = false;
				for(int i=0; i<9; i++) {
					if(Kcards[i] == j) {
						isKcard = true;
						break;
					}
				}
				if(!isKcard) {
					Icards[iIdx++] = j;
				}
			}
			//초기화
			lose = 0;
			win = 0;
			isUsed = new boolean[9];
			scenario = new int[9];
			backTracking(0);
			System.out.printf("#%d %d %d\n", t, win, lose);
//			System.out.println(Arrays.toString(Icards));
				
		}
	}
	
	public static void backTracking(int depth) {
		if(depth == 9) {
			//만약 시나리오 하나가 완성되면
			//그 경우에 대해 이겼는지 졌는지 확인
			check();
			return;
		}
		for(int i=0; i<9; i++) {//인영이의 아홉개 카드중에서 순열 뽑기
			if(!isUsed[i]) {
				isUsed[i] = true;
				scenario[depth] = Icards[i];
				backTracking(depth+1);
				isUsed[i] = false;
			}
		}
	}

	private static void check() {
		int K = 0;
		int I = 0;
		for(int i=0; i<9; i++) {
			if(Kcards[i]>scenario[i]) {//규영의 카드가 더 크면 
				K+=Kcards[i]+scenario[i];
			} else {
				I += Kcards[i]+scenario[i];
			}
		}
		//K와 I의 점수 비교
		if(K>I) {
			win++;
		} else if (I>K) {
			lose++;
		} //무승부에 대해서는 카운트하지 않음.
	}
}
