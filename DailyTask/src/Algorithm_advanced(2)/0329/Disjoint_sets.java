import java.util.ArrayList;
import java.util.List;

public class Disjoint_sets {
	//Make-set : 집합생성
	//Find-set : 대표자 반환
	//Union : x,y를 하나의 그룹으로 - 대표자를 인자로 받아야 한다.
	//일개 조직원이 조직합치자고 못하는 느낌
	
	//상호배타집합을 표현하는 방법 - 연결리스트 / 트리
	static int[] parents;
	static int[] rank;

	public static void main(String[] args) {
		parents = new int[6];
		rank = new int[6]; //0으로 초기화
		
		//초기상태에서 모든 원소의 대표자는 자기 자신. = makeSet
		for(int i=0; i<6; i++) {
			parents[i] = i;
		}
	}

	public static int FindSet(int x){//X를 포함하는 집합을 찾는 연산
		if(x == parents[x]) return x;
		else {
			return FindSet(parents[x]);
		}
	}
	
	public static void Union(int x, int y) {//y의 집합이 x로 들어가는 것.
		parents[FindSet(y)] = FindSet(x);
	}
	
	//1.랭크를 이용한 union
	//깊이가 더 작은 친구를 큰 쪽에다가 붙이기
	//그럼 높이변화는 큰쪽에 일어나지 않음
	//만약 높이가 똑같다면?
	//아무대나 붙여도 상관없음. 대신 붙이고 나서 값을 하나 증가시켜주어야 함.
	
	//2.Path compression
	//모든 자손들이 부모를 직접 가리키도록 하는 방법
	
	public static int FindSet_PathComp(int x){//X를 포함하는 집합을 찾는 연산
		if(x!=parents[x]) {
			parents[x] = FindSet_PathComp(parents[x]);
		}
		//계속 부모를 거슬러 올라가기.
		//if조건을 넘어오면 parent = child
		return parents[x];
		//부모 = 자식 같으면 대빵이므로 대빵을 리턴.
	}
	
	//개선된 Union
	public static void link(int x, int y) {
		if(rank[x] > rank[y]) {
			parents[y] = x;//y가 x에 붙도록 (y의 부모가 x를 가리킴)
		} else {
			parents[x] = y;//x가 y에 붙도록 (x의 부모가 y를 가리킴)
			//만약 둘의 랭크가 같다면, 
			if(rank[x] == rank[y]) {
				rank[y]++;//y에 자식 하나 더생겼으니까 ++
			}
		}
	}
}
