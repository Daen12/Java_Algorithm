package solving_club;

import java.util.Scanner;

public class Q9480_민정이와광직이의알파벳공부_D3 {
	boolean[] visited;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[] alphabets = new int[26]; //1-26의 알파벳 인덱스가 들어갈 카운트배열
		for(int t=1; t<=T; t++) {
			int N = in.nextInt();
			String[] words = new String[N];
			for(int i=0; i<N; i++){
				words[i] = in.next();
			} //단어를 문자열형태로 words배열에 넣어주기.
			
		}
		//조합해서 만들 수 있는 단어세트의 개수 = 순열? (중복 oK)
		//i는 고를 인덱스. 1-N개까지 단어를 고를 수 있음
		
	}
//	static int[] combination(int[] words, boolean[] visited, int start, int n, int r) {
//		//r은 뽑을 개수, n은 배열의 길이
//		//start는 기준
//		//start보다 작으면 뽑을 후보에서 제외, 크면 뽑을 후보
//		if(r==0) {
//			return returnIdx(words, visited);
//		
//		} else {
//			for(int i = start; i<n; i++) {
//				visited[i] = true;
//				combination(words, visited, i+1, n, r-1);
//				visited[i] = false;
//			}
//		}
//		
//	}
//	static int[] returnIdx (int[] words, boolean[] visited) {
//		int[] idx = 
//		for(int i=0; i<words.length; i++) {
//			if(visited[i] == true) {
//				
//			}
//		}
//	}
}
