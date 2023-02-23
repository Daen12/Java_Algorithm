package solving_club;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q14696_딱지놀이_bronze1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int a =  Integer.parseInt(st1.nextToken());
			int[] A = new int[a];
			for(int i=0; i<a; i++) {
				A[i] = Integer.parseInt(st1.nextToken());
			}
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int b =  Integer.parseInt(st1.nextToken());
			int[] B = new int[b];
			for(int i=0; i<b; i++) {
				B[i] = Integer.parseInt(st1.nextToken());
			}
			Arrays.sort(A, Collections.reverseOrder());
			
		}
	}
}
