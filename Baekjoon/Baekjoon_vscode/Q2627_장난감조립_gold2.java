import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q2627_장난감조립_gold2 {
	static List<Node>[] graph;
	static int[] inD, count;
	static int N, ans;
	static Queue<Node> queue;

	static class Node {
		int num;
		int cnt;

		public Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();// 몇번노드까지7
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();// 초기화
		}
		inD = new int[N + 1];
		int[] checkBasic = new int[N + 1];
		count = new int[N + 1];
		// 입력받기
		int M = in.nextInt();
		for (int i = 0; i < M; i++) {
			int x = in.nextInt();// 최종
			int y = in.nextInt();// 재료
			int z = in.nextInt();// 몇개
			checkBasic[x]++;
			inD[y]++;
			graph[x].add(new Node(y, z));// 5번 인덱스에 재료1, 2 들어가는 구조
		}
		TopSort();

		for (int i = 1; i < N + 1; i++) {
			if (checkBasic[i] == 0) {
				System.out.println(i + " " + count[i]);
			}
		}
	}

	public static void TopSort() {
		queue = new LinkedList<>();
		queue.offer(new Node(N, 1));
		count[N] = 1;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (Node n : graph[node.num]) {
				count[n.num] += count[node.num] * n.cnt;
				inD[n.num]--;
				if (inD[n.num] == 0) {
					queue.offer(new Node(n.num, count[n.num]));
				}
			}
		}
	}
}