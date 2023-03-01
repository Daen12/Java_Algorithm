package solving_club;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1248_공통조상_D5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(br.readLine()); // 10
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 13
			int E = Integer.parseInt(st.nextToken()); // 12
			int ch1 = Integer.parseInt(st.nextToken()); // 8
			int ch2 = Integer.parseInt(st.nextToken()); // 13
			// 이진트리 배열 만들기
			List<Integer> list = new ArrayList<>();
			// 하나밖에 없으면 -> 2*i에 값 저장. 2*i+1은 비워놓기.
			// 두개 있으면 -> 두군데 인덱스에 값 저장.
			int[] count = new int[N + 1];
			String[] input = br.readLine().split(" "); // 문자열 형태
			int[] arr = new int[(int) Math.pow(2, N)];
			arr[1] = 1;
			for (int i = 0; i < input.length; i += 2) {
				int parent = Integer.parseInt(input[i]);
				int paIdx = 0;
				// parent의 인덱스 구하기.
				for (int d = 0; d < arr.length; d++) {
					if (arr[d] == parent) {
						paIdx = d;
					}
				}
				int child = Integer.parseInt(input[i + 1]);
				// 만약 parent자리가 없으면
				if (count[parent] == 0) {
					arr[paIdx * 2] = child;
					count[parent]++;
				} else { // parent의 인덱스를 구하기
					arr[paIdx * 2 + 1] = child;
				}
			}
			System.out.println(Arrays.toString(arr));
			// 여기까지 배열화
			// 루트노드는 ch1와 ch2의 최소공배수
			// parent의 인덱스 구하기.
			int ch1Idx = 0, ch2Idx = 0;
			for (int d = 0; d < arr.length; d++) {
				if (arr[d] == ch1) {
					ch1Idx = d;
				}
				if (arr[d] == ch2) {
					ch2Idx = d;
				}
			}
			//root의 모든 자식들의 수를 카운트!
			int root = getRoot(ch1Idx, ch2Idx);
			int countNodes = countNodes(root, arr);
			System.out.printf("#%d %d %d\n", t, root, countNodes);
		}
	}

	public static int getRoot(int a, int b) {
		int div1 = Math.min(a, b); // 13
		while (div1 >= 1) {
			div1 = div1 / 2; //6
			int div2 = Math.max(a, b); // 28
			while (div2 >= 1) {
				div2 = div2 / 2; //0
				if (div1 == div2) {
					return div1;
				}
			}
		}
		return -1;
	}
	public static int countNodes(int root, int[]arr) {
		int count = 1;
		if(arr[root*2] != 0) {
			count++;
		}
		if(arr[root*2+1]!=0) {
			count++;
		}
		
		
		return 0;
	}
}
