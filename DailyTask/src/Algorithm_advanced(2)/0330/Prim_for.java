import java.util.Arrays;
import java.util.Scanner;

public class Prim_for {
	//왜 아무 정점이나 선택해도 될까?
	//신장트리의 특징 : 모든 정점을 최소한의 간선을 이용해서 연결할 것이므로
	//아무 정점에서나 시작해도 된다.
	
	//5번 방문처리 - DIST 0
	//5번과 연결된 모든 노드의 거리 최솟값 거리배열에 저장
	//어디서 왔는지 (5) 저장
	//이중 최솟값 뽑기 (뽑혔다 = 최선의 선택이다)
	//3번 방문처리
	//연결된 모든 노드의 거리 최솟값 거리배열에 저장.
	//어디서왔는지(3) 저장
	//이 중 최솟값 뽑기 = 4번 방문처리
	//연결된 모든 노드의 거리에 대해 최솟값 갱신 
	//어디서 왔는지 (4)
	//최솟값은 이제 2번 = 방문처리
	//최솟값 갱신 후 뽑기6
	//남은 노드 0번 어디서 왔는지 확인 후 (2) 0-2 마지막으로 선택!
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
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(input);
		int V = in.nextInt();
		int E = in.nextInt();
		
		int[][] adjArr = new int[V][V];
		
		for(int i=0; i<E; i++) {
			int A = in.nextInt();//시작정점
			int B = in.nextInt();//도착정점
			int W = in.nextInt();//가중치
			//무향그래프!
			adjArr[A][B] = W;
			adjArr[B][A] = W;
			
		}
		//방문처리를 위한 배열
		boolean[] visited = new boolean[V];
		int[] p = new int[V]; //어디에서 왔니?
		int[] dist = new int[V];//최솟값을 저장하는 배열
		Arrays.fill(dist, INF); //최댓값을 거리 저장 초기화
		
		//임의의 한 점을 선택 후 돌리기
		dist[0] = 0; //0번 정점으로 시작해보자.
		p[0] = -1;
		int ans = 0;
		
		//prim!
		for(int i=0; i<V-1; i++) {//정점개수만큼 돌아도 상관없음! V
			//1.최솟값을 뽑기
			int min = INF;
			int idx = -1;
			//아직 안뽑힌 친구 중 가장 작은 값 뽑기
			for(int j=0; j<V; j++) {
				if(!visited[j] && dist[j]<min) {
					min = dist[j];
					idx = j;//가장 작은 값을 가진 정점
				}
			}
			visited[idx] = true;
			
			//2.뽑은 정점으로 갱신 가능한 값이 있다면 갱신
			//인접행렬이니까 모든 정점을 확인하는것.
			for(int j=0; j<V; j++) {
				if(!visited[j] && adjArr[idx][j]!=0 && dist[j]>adjArr[idx][j]) {
					dist[j] = adjArr[idx][j];
					p[j] = idx;
				}
			}
		}
		for(int i=0; i<V; i++) {
			ans+=dist[i];
		}
		System.out.println(ans);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
