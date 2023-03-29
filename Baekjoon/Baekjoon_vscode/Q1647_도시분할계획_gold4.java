import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q1647_도시분할계획_gold4 {
	static class road {
		int x, y, cost;

		public road(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}

	static int[] house;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		road[] village = new road[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			village[i] = new road(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		} // 간선 정보 저장 완료

		house = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			house[i] = i;
		} // 집(노드) 초기화 완료

		Arrays.sort(village, new Comparator<road>() {
			public int compare(road o1, road o2) {
				return o1.cost - o2.cost;
			}
		});// 간선 배열 비용에 따른 오름차순 정렬 완료

		// for (road r : village) {
		// System.out.print(r.cost + " ");
		// }
		int minCost = 0;
		int pick = 0;
		for (int i = 0; i < M; i++) {
			int x = village[i].x;
			int y = village[i].y;
			if (findSet(x) != findSet(y)) {
				union(x, y);
				pick++;
				minCost += village[i].cost;
				// 마지막 i 저장
				pick = i;
			}
		}
		System.out.println(minCost - village[pick].cost);
	}

	public static int findSet(int x) {
		if (house[x] != x) {
			house[x] = findSet(house[x]);
		}
		return house[x];
	}

	public static void union(int x, int y) {
		house[findSet(y)] = findSet(x);
	}
}
