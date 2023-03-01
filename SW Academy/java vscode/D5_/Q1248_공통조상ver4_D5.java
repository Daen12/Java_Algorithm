import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1248_공통조상ver4_D5 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt(); // 10
		for (int t = 1; t <= T; t++) {
			int N = in.nextInt(); // 13
			int E = in.nextInt();// 12
			int ch1 = in.nextInt();// 8
			int ch2 = in.nextInt();// 13

			count = 0;

			int[][] tree = new int[N + 1][2]; // 트리 이중배열 (인덱스:부모, 값:양쪽자식)
			for (int i = 1; i <= E; i++) {
				int parent = in.nextInt();
				int child = in.nextInt();
				if (tree[parent][0] == 0) {// 부모인덱스 0번째 값 없으면
					tree[parent][0] = child; // 추가
				} else { // 있으면
					tree[parent][1] = child; // 1번째에 추가
				}
			}
			// 조상찾기
			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();

			while (ch1 != 1) {// 둘다 1이면 break
				for (int i = 1; i <= N; i++) { // 부모의
					for (int j = 0; j <= 1; j++) { // 양쪽자식
						if (tree[i][j] == ch1) { // 이 첫번째 원소와 같으면
							list1.add(i);// 리스트에 넣고
							ch1 = i; // 부모로 원소 갱신
						}
					}
				}
			}
			while (ch2 != 1) { // 두번째 원소 똑같이
				for (int i = 1; i <= N; i++) {
					for (int j = 0; j <= 1; j++) {
						if (tree[i][j] == ch2) {
							list2.add(i);
							ch2 = i;
						}
					}
				}
			}
			int root = 1;
			outer: for (int i = 0; i < list1.size(); i++) { // a랑 b 하나씩 비교해서 찾기
				for (int j = 0; j < list2.size(); j++) {
					if (list1.get(i).equals(list2.get(j))) {
						root = list1.get(i);
						break outer;
					}
				}
			}
			countNodes(root, tree);
			System.out.printf("#%d %d %d\n", t, root, count);
		}
	}

	static int count = 0;

	public static void countNodes(int root, int[][] tree) {
		count++;
		if (tree[root][0] != 0) {
			countNodes(tree[root][0], tree);
		}
		if (tree[root][1] != 0) {
			countNodes(tree[root][1], tree);
		}
	}
}
