package solving_club;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q8958_OX퀴즈_bronze2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			char[] input = br.readLine().toCharArray();
			
			int total = 0;
			int temp = 0;
			for(int i=0; i<input.length; i++) {
				if(input[i] == 'O') {
					temp+=1;
					total+=temp;
				} else {
					temp = 0;
				}
			}
			System.out.println(total);
		}
	}
}
