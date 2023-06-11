import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort_Stack {
	//Queue의 역순으로 알고리즘이 진행된다.
	
	//각 '노드'를 기준으로 구성이 됨.
	
	static Stack<Integer> stack;
	static int V,E;
	static boolean[] visited;
	static int[] inDegree;
	static ArrayList<Integer>[] graph;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		V = in.nextInt();//9
		E = in.nextInt();//9
		inDegree = new int[V+1];
		//위상정렬에 사용할 그래프 2차원 리스트로 구현
		graph = new ArrayList[V+1];
		for(int i=0; i<V+1; i++) {
			graph[i] = new ArrayList<Integer>();//리스트안의 값 리스트로 초기화
		}
		
		for(int i=0; i<E; i++) {//간선의 개수만큼
			int st = in.nextInt();
			int ed = in.nextInt();
			graph[st].add(ed);
			inDegree[ed]++;//인덱스는 노드번호를 나타냄.
		}
		visited = new boolean[V+1];
		stack = new Stack<>();
		
		for(int i=1; i<V+1; i++) {
			if(inDegree[i] == 0) TopologicalSort(i);
		}
		//마지막으로 출력하기!
		for(int s : stack) {
			sb.append(stack.pop() + " ");
		}
		
	}
	
	public static void TopologicalSort(int i){
	
		visited[i] = true;//방문처리
		for(int n : graph[i]) {//인접 노드들에 대해서
			if(!visited[n]) {//방문하지 않았으면
				TopologicalSort(n);//재귀
			}
		}
		stack.push(i);//재귀에서 빠져나오면 스택에 넣기 

	}
}
