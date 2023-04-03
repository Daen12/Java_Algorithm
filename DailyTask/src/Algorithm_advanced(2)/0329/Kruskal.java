import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Kruskal {
	static int[] parents;
	static String input = "7 11\r\n" + 
			"0 1 32\r\n" + 
			"0 2 31\r\n" + 
			"0 5 60\r\n" + 
			"0 6 51\r\n" + 
			"1 2 21\r\n" + 
			"2 4 46\r\n" + 
			"2 6 25\r\n" + 
			"3 4 34\r\n" + 
			"3 5 18\r\n" + 
			"4 5 40\r\n" + 
			"4 6 51";
	
	public static void main(String[] args) {
		Scanner in = new Scanner(input);
		int V = in.nextInt();
		int E = in.nextInt();
		parents = new int[V];
		//간선 저장하기 위해 배열을 이용.
		//0 : 시작정점, 1:끝정점, 2:가중치
		int[][] edges = new int[E][3];
		for(int i=0; i<E; i++) {
			edges[i][0] = in.nextInt();
			edges[i][1] = in.nextInt();
			edges[i][2] = in.nextInt();
		}
		//kruskal level 1.간선을 정렬한다.=오름차순!
		//이게 최소값을 반환하도록 하는 방법임.
		Arrays.sort(edges, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				//양수이면 자리바꿈. 0과 음수는 그대로
				return o1[2] - o2[2];
			}
		});
		
		//kruskal level2. V-1개의 간선을 사이클 안발생하도록 뽑는다.
		parents = new int[V];
		//make-set
		for(int i=0; i<V; i++) {
			parents[i] = i;
		}
		int minCost = 0;//최소 비용
		int pick = 0;//뽑은 간선의 수
		//모든 간선을 순회하면서 판단하기
		for(int i=0; i<E; i++) {
			//i번째의 간선을 뽑아, 두 정점의 대표를 확인하기
			int x = edges[i][0];
			int y = edges[i][1];
			//대표를 처음부터 넣어줄수도 있음 px = findset(x) / py = findset(y)!!
			if(findset(x) != findset(y)) {
				//두 노드의 조상이 다르다면 = 사이클이 아님
				union(x,y);
				minCost+=edges[i][2];//비용 더하기
				pick++;
			}
			if(pick == V-1) break; //모든 간선을 뽑았다면 브레이크
		}
		System.out.println(minCost);
	}
	
	static int findset(int x) {//Path compression!
		if(parents[x] != x) {
			parents[x] = findset(parents[x]);
		}
		return parents[x];
	}
	static void union(int x, int y) {
		parents[findset(y)] = findset(x);//랭크 따로 고려하지 않음.
		//y를 무조건 x 밑으로!
		
	}
}
