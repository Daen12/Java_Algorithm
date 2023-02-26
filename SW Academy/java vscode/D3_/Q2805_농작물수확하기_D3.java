package solving_club;

import java.util.Scanner;

public class Q2805_농작물수확하기_D3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			int N = in.nextInt();
			int Sum = 0;
			for(int n=0; n<N; n++) { //0 1 2 3 4 // N/2 //01210
				// 한줄씩 받으면서  (n%N/2) 
				String[] line = in.next().split(""); //[1,4,0,5,4]
				int mid = N/2; //2
				if(n<N/2) { //중간인덱스보다 작을때
					for(int m=mid-n; m<=mid+n; m++) {
						Sum+=Integer.parseInt(line[m]);
					}
				} else { //중간인덱스보다 클때
					for(int m=mid-(2*mid-n); m<=mid+(2*mid-n); m++) {
						Sum+=Integer.parseInt(line[m]);
					}
				}
				
			}
			System.out.printf("#%d %d", t, Sum);
			System.out.println();
		}
		//12345
		//3  234  12345  234  3
		//1234567 N/2 = 3 2-4
		//4  345  23456  1234567  23456 345  4
		
	}
}
