package solving_club;

import java.util.Arrays;
import java.util.Scanner;

public class Q1860_진기의최고급붕어빵inclass_D3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            String answer = "Possible";
            int N = in.nextInt(); // 몇명
            int M = in.nextInt(); // 몇초동안 //4
            int K = in.nextInt(); // 몇개 붕어빵? //3

            int[] times = new int[11112]; //i초에 오는 손님의 수
            
            //N명의 도착시간이 주어짐.
            for(int i=0; i<N; i++) {
            	int time = in.nextInt();
            	times[time]++; //해당 시간에 도착하는 손님의 수 세기
            }
            //0초, 1초, 2초, ...11111초까지 반복하면서
            //붕어빵 만들고
            //해당 초에 도착 손님 있다면 손님 수만큼 붕어빵 나눠주고
            //만약에 나눠줄 수 없다면
            //Impossible!
            int bread = 0;
            for(int i=0; i<=11111; i++) {
            	if(i!=0 && i % M == 0) bread+=K;
            	if(bread-times[i]<0) {
            		answer = "Impossible";
            		break;
            	}
            }
            System.out.println("#" + t + " " + answer);
        }
    }
}
