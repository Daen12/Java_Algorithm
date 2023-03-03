package solving_club;

import java.util.Arrays;
import java.util.Scanner;

public class Q7732_시간개념_D3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			String time = "";
			String[] input1 = in.next().split(":");
			String[] input2 = in.next().split(":");
			int[] from = new int[3];
			int[] to = new int[3];
			int[] calc = new int[3];
			for(int i=0; i<input1.length; i++) {
				from[i] = Integer.parseInt(input1[i]);
				to[i] = Integer.parseInt(input2[i]);
			}
//			System.out.println(Arrays.toString(from));
//			System.out.println(Arrays.toString(to));
			//0시간 1분 2초
			if(to[2] - from[2]<0) { //초 계산
				to[1]--; //분에서 1 빼주고
				calc[2] = to[2]+60-from[2];
			} else {
				calc[2] = to[2]-from[2];
			}
			
			if(to[1] - from[1]<0) { //분 계산
				to[0]--; //분에서 1 빼주고
				calc[1] = to[1]+60-from[1];
			} else {
				calc[1] = to[1]-from[1];
			}
			
			if(to[0] - from[0]<0) { //분 계산
				calc[0] = to[0]+24-from[0];
			} else {
				calc[0] = to[0]-from[0];
			}
			
	
			
			System.out.printf("#%d %02d%s%02d%s%02d\n", t, calc[0], ":", calc[1], ":", calc[2]);
		}
	}
}
