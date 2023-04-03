import java.util.Scanner;

public class 그래프_01_인접행렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt(); // 정점의 개수를 입력을 받는다. (6 이다. 시작정점이 0번인지 / 1번인지)
		int E = sc.nextInt(); // 간선의 수가 입력 된다.

		int[][] adjArr = new int[V + 1][V + 1];

		// 간선을 입력을 받자.
		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();

			//유향 그래프라면 20번라인은 필요없다.
			adjArr[st][ed] = 1;
			//무향그래프일때 아래도 같이 작성을 해준다.
			adjArr[ed][st] = 1;
			
			adjArr[st][ed] = adjArr[ed][st] = 1; //한줄적기 가넝
		}
	}
}
