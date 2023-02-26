package solving_club;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q3499_퍼펙트셔플_D3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			//문자들의 배열 만들기
			String[] input = br.readLine().split(" ");
			System.out.println(Arrays.toString(input));
			
			int cutPoint = N%2 ==0? N/2 : N/2+1; //3
			System.out.println(cutPoint);
			//cutpoint부터 끝까지 돌면서 queue에 넣기
			//0부터 cutpoint전까지 queue에 넣기
			Queue<String> q2 = new LinkedList<>();
			for(int i=cutPoint; i<N; i++) {
				q2.offer(input[i]);
			}
			
			String answer = "";
			for(int i=0; i<cutPoint-1; i++) {
				answer+=input[i]+" ";
				answer+=q2.poll()+" ";
			}
			
//			answer+=input[cutPoint-1];
			if(N%2==0) {
				answer+=input[cutPoint-1]+" ";
				answer+= q2.poll();
			} else {
				answer+=input[cutPoint-1];
			}
			
			
			
			System.out.println("#"+t+" "+answer);
					
		}
	}

}
