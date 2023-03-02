package solving_club;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1231_중위순회_D4 {
	static char[] arr;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new char[N+1];
			for(int n=0; n<N; n++) {
				String[] input = br.readLine().split(" ");
				int idx = Integer.parseInt(input[0]);
				char alphabet = input[1].charAt(0);
				arr[idx] = alphabet;
			}
			System.out.print("#"+t+" ");
			n = arr.length;
			traverse(1); // 1번 노드부터 스택에 올리기
			System.out.println();
		}
		
	}

	private static void traverse(int i) {
		if (i <= n - 1) {
			// L : 왼쪽트리로 탐색을 이어나감.
			traverse(i * 2);
			// V
			if (arr[i] != ' ') {
				System.out.print(arr[i]);
			}
			// R : 오른쪽으로 탐색
			traverse(i * 2 + 1);
		}
	}

}
