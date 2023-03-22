import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Q10726_이진수표현_D3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			int N = in.nextInt();
			int M = in.nextInt();
			//N을 이진수로 만들어 배열에 담기
			LinkedList<Integer> mods = new LinkedList<>();
			if(M == 0) {
				mods.add(0);
			}
			while(M>0) {
				mods.add(M%2);
				M = M/2;
			}
			String result = "ON";
			for(int i =0; i<N; i++) {
				if(mods.get(i)==0) {
					result = "OFF"; //꺼져있다면 off, 바로 루프 종료
					break;
				}
			}
			System.out.printf("#%d %s\n", t, result);
		}
	}
}
