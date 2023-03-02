package solving_club;

import java.util.Scanner;

public class Q1940_가랏RC카_D2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			int N = in.nextInt();
			int distance = 0;
			int speed = 0;
			for(int n=1; n<=N; n++) {
				int order = in.nextInt(); //명령
				if(order == 1) {
					speed+=in.nextInt();
					distance+=speed;
				}
				if(order == 0) {
					distance+=speed;
				}
				if(order == 2) {
					speed-=in.nextInt();
					speed = speed<0? 0 : speed;
					distance+=speed;
				}
			}
			System.out.printf("#%d %d\n", t, distance);		
		}
		
	}
}
