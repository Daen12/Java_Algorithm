package solving_club;

import java.util.Arrays;
import java.util.Scanner;

public class J_1205_조커80 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] cards = new int[N];
		int Joker = 0;
		for (int n = 0; n < N; n++) {
			cards[n] = in.nextInt();
			if (cards[n] == 0) // 0이면 조커개수 증가
				Joker++;
		}
		Arrays.sort(cards);
		int max = 0;
		int count = 1;
		int useJoker = Joker;
		for (int i = Joker; i < N - 1; i++) {
			int diff = cards[i + 1] - cards[i];
			//n이 끝일때 / 끝이 아닐때
			//0의 개수가 숫자의 개수보다 크면 -> 0의 개수만큼 스트레이트 
			if(i != N-2) {
		        if (diff == 1) { //정렬 시 앞의 카드와 1 차이나면 count++
	                count++;
	            } else {
	                if (diff-1 > 0 && diff - 1 <= useJoker) { //필요 장수(연속 같은 카드 아닌경우)
	                	useJoker -= (diff - 1);
	                    count+=(diff);
	                } else {
	                	count+=useJoker;
	                    // 카운트의 max갱신
	                    if (count > max) {
	                        max = count;
	                    }
	                    count = 1;
	                    useJoker = Joker;
	                }
	            }
			} else {
				if (diff == 1) { // 정렬 시 앞의 카드와 1 차이나면 count++
					count++;
				}
				if (diff - 1 > 0 && diff - 1 <= useJoker) { // 필요 장 수(연속 같은 카드 아닌 경우)
					useJoker -= (diff - 1);
					count += (diff);
				}
				if (i == N - 2 || !(diff - 1 > 0 && diff - 1 <= useJoker)) {
					count += useJoker;
					// 카운트의 max갱신
					if (count > max) {
						max = count;
					}
					count = 1;
					useJoker = Joker;
				}
			}
		}
		System.out.println(max>Joker? max : Joker);
	}
}
