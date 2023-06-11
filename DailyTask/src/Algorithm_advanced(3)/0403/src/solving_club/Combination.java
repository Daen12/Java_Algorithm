package solving_club;

public class Combination {
	static int W = 10;
	static int N = 3;
	static int cnt;
	static boolean[] visited;
	public static void main(String[] args) {
		visited = new boolean[W];
		Combination(0,0);
		
		
	}
	
	public static void Combination(int depth, int idx) {// combination/permutation
		if (depth == N) {
			cnt = 0;
			for (int c = 0; c < W; c++) {
				if (visited[c]) {// 고른 칼럼에 대해 shoot
					System.out.print(c + " ");
//					init(c);
				}
			}
			System.out.println();
			return;
		}
		for (int i = idx; i < W; i++) {
			visited[i] = true;
			Combination(depth + 1, i + 1);
			visited[i] = false;
		}
	}
}
