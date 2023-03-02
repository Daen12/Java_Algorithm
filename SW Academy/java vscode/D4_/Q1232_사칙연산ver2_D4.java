package solving_club;

import java.util.Arrays;
import java.util.Scanner;

public class Q1232_사칙연산ver2_D4 {
//	static int N;
//	static String[][] tree; // char형태로 연산자와 숫자를 받기
//	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for (int t = 1; t <= 1; t++) {
			int N = in.nextInt();
			String space = in.nextLine();
			String[][] tree = new String[N + 1][3]; // 본인, 왼쪽자식, 오른쪽자식
			for (int n = 1; n <= N; n++) {
				String[] line = in.nextLine().split(" ");
//				System.out.println(Arrays.toString(line));
				int idx = Integer.parseInt(line[0]); // 인덱스
				char[] what = line[1].toCharArray();

				if (Character.isDigit(what[0])) {
					tree[idx][0] = line[1];
				} else {
					tree[idx][0] = line[1];
					tree[idx][1] = line[2];// 왼쪽자식
					tree[idx][2] = line[3];// 오른쪽자식
				}
			}
//			for(int i=0; i<N+1; i++) {
//				System.out.println(Arrays.toString(tree[i])); 
//			}
			// 만들어진 트리에 대해서, 연산 수행
			// 뒤에서부터 돌면서, 연산자를 만나면 연산 수행하여 값 넣기
			for (int i = N; 1 <= i; i--) { // 5

				if(tree[i][0].equals("*")) {
					int leftIdx = Integer.parseInt(tree[i][1]);
					int rightIdx = Integer.parseInt(tree[i][2]);
					tree[i][0] = String.valueOf(Integer.parseInt(tree[leftIdx][0])  * Integer.parseInt(tree[rightIdx][0])) ;
				}
				if(tree[i][0].equals("+")) {
					int leftIdx = Integer.parseInt(tree[i][1]);
					int rightIdx = Integer.parseInt(tree[i][2]);
					tree[i][0] = String.valueOf(Integer.parseInt(tree[leftIdx][0])  + Integer.parseInt(tree[rightIdx][0])) ;
				}
				if(tree[i][0].equals("/")) {
					int leftIdx = Integer.parseInt(tree[i][1]);
					int rightIdx = Integer.parseInt(tree[i][2]);
					tree[i][0] = String.valueOf(Integer.parseInt(tree[leftIdx][0])  / Integer.parseInt(tree[rightIdx][0])) ;
				}
				if(tree[i][0].equals("-")) {
					int leftIdx = Integer.parseInt(tree[i][1]);
					int rightIdx = Integer.parseInt(tree[i][2]);
					tree[i][0] = String.valueOf(Integer.parseInt(tree[leftIdx][0])  - Integer.parseInt(tree[rightIdx][0])) ;
				
				}
				

			}

			System.out.printf("#%d %s\n", t, tree[1][0]);
		}

	}

}
