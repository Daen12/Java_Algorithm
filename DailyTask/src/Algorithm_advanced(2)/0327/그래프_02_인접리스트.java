import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_02_인접리스트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt(); // 정점의 개수를 입력을 받는다. (6 이다. 시작정점이 0번인지 / 1번인지)
		int E = sc.nextInt(); // 간선의 수가 입력 된다.
		//"정수가 들어있는 list의 배열"
		List<Integer>[] adjList = new ArrayList[V+1]; //각각 리스트를 담을 수 있는 배열을 만든 것!
		//안에 null이 들어간 상태.
		//arraylist이므로 안의 숫자 개수는 자유자재!
		for(int i = 0 ; i<V+1; i++) {
			adjList[i] = new ArrayList<>();//그 안의 인스턴스를 실제로 만들어줘야 초기화가 됨 - 
										//nullpointer exception 안남!
		}
		
		// 간선을 입력 받자.
		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();

			//유향 그래프라면 밑의 과정은 필요없다.
			adjList[st].add(ed);
			//무향그래프일때 아래도 같이 작성을 해준다.
			adjList[ed].add(st);
		}
	}
}
