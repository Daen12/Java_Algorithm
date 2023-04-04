import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q5644_무선충전 {
	//각 충전기의 좌표들을 배열에 저장
	//맵에 충전기 성능을 입력하고, 겹치면 해당 충전기들에 그 좌표 저장

	static List<Integer>[] overlaps;//리스트(x,y좌표 병렬)->배열(충전기개수)
	static int[][] map;
	static int[] Apath, Bpath, funcList;
	static int aR, aC, bR, bC;
	static int M,A, sum;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			M = in.nextInt(); //이동시간
			A = in.nextInt(); //충전기의 개수
			Apath = new int[M];
			Bpath = new int[M];
			
			for(int i=0; i<M; i++) {
				Apath[i] = in.nextInt();
			}
			for(int i=0; i<M; i++) {
				Bpath[i] = in.nextInt();
			}
			
			//충전기 배열 초기화
			overlaps = new ArrayList[A+1];
			for(int i=0; i<A+1; i++) {
				overlaps[i] = new ArrayList<>();
			}
			funcList = new int[A+1];
			//맵 생성
			map = new int[10][10];
			//충전기 정보저장
			for(int i=1; i<A+1; i++) {
				int C = in.nextInt()-1;
				int R = in.nextInt()-1;//1기준 인덱스니까 하나빼기
				int range = in.nextInt();
				int func = in.nextInt();
				//어떤 충전기에 성능 몇인지 저장
				funcList[i] = func;
				//좌표 중심으로 범위안에 들면 좌표에 해당 성능번호 저장
				for(int r=0; r<10; r++) {
					for(int c=0; c<10; c++) {
						if(dist(R,C,r,c)<=range) {
							overlaps[i].add(r);//행
							overlaps[i].add(c);//열 차례대로
							
							if(map[r][c] == 0) {//비어있으면
								map[r][c] = i;//어떤충전기 범위인지 저장
							} else {//다른충전기도 잡히는곳이면
								map[r][c] = -1;//일단 -1
							}
						}
					}
				}
			}
			for(int[] line : map) {
				System.out.println(Arrays.toString(line));
			}
			aR = 0; aC = 0; bR = 9; bC = 9;
			sum = 0;
			init();
			System.out.printf("#%d %d\n", t, sum);
		}
	}
	
	public static void init() {
		for(int i=0; i<M+1; i++) {//방향키 탐색
			
			//둘다 -1이 아니면 = 더할 값이 하나씩만 있는것이므로 그대로 더하기!
			if(map[aR][aC]!=-1 && map[bR][bC]!=-1) {
				if(map[aR][aC] == map[bR][bC]) {//같은거 공유
					sum+=funcList[map[aR][aC]];
				} else {//다른거 
					sum+=funcList[map[aR][aC]];
					sum+=funcList[map[bR][bC]];
				}
			} else {
				//둘중 최소 하나가 -1이면 (잡히는 신호 두개이상)
				sum+=compare();
			}
//			//전라운드에서 이동 한 좌표 + 이동후 계산한 좌표
//			System.out.println("Sum : "+sum+" ");
//			System.out.println(aR+" "+aC+ ": "+map[aR][aC]);
//			System.out.println(bR + " "+ bC+": "+map[bR][bC]);
//			System.out.println("===");
			
			if(i!=M) {
			move("A", Apath[i]);//각자 한번씩 이동
			move("B", Bpath[i]);
			}
		}
	}
	public static int compare() {
		//overlaps 리스트에서 각 충전기마다 해당 좌표가 있는지 확인
		//좌표 있는 충전기만 뽑아서 arrayList에 담기
		List<Integer> gadgets = new ArrayList<>();
		List<Integer> gadgets2 = new ArrayList<>();
		for(int i=1; i<A+1; i++) {//모든 충전기를 돌면서
			for(int j=0; j<overlaps[i].size(); j+=2) {//두칸씩 r,c / 충전기의 좌표에 해당좌표 있으면
				if(overlaps[i].get(j) == aR && overlaps[i].get(j+1) == aC) {
					gadgets.add(i);//그 충전기 더하기
				}
				if(overlaps[i].get(j) == bR && overlaps[i].get(j+1) == bC) {
					gadgets2.add(i);
				}
			}
		}
		if(gadgets.size() == 0) gadgets.add(0);
		if(gadgets2.size() == 0) gadgets2.add(0);
		
		int temp = 0;
		//각 경우를 계산하여 max값 갱신
		for(int i=0; i<gadgets.size(); i++) {
			for(int j=0; j<gadgets2.size(); j++) {
				if(gadgets.get(i) == gadgets2.get(j)) {
					temp = Math.max(temp, funcList[gadgets.get(i)]);
				} else {
					temp = Math.max(temp, funcList[gadgets.get(i)] + funcList[gadgets2.get(j)]);
				}
			}
		}
		return temp;
	}
	public static void move(String person, int num) {
		if(person == "A") {
			switch(num) {
			case 0 : 
				break;
			case 1 : aR--;
				break;
			case 2 : aC++;
				break;
			case 3 : aR++;
				break;
			case 4 : aC--;
				break;
			}
		} else {
			switch(num) {
			case 0 : 
				break;
			case 1 : bR--;
				break;
			case 2 : bC++;
				break;
			case 3 : bR++;
				break;
			case 4 : bC--;
				break;
			}
		}
		
	}
	public static int dist(int R, int C, int r, int c) {
		return Math.abs(R - r) + Math.abs(C - c);
	}
	
	
	
	
//	//범위 안겹치면 각각 좌표의 값 저장
//	if(map[aR][aC] != map[bR][bC]) {
//		
//	} else {
//		//네가지 경우
//		//1. A가 -1. B가 충전기 하나일때
//		//2. A가 충전기 하나, B가 -1일 떄
//		//3. 둘다 충전기 하나일때
//		//4. 둘다 -1일 때
//		
//		if(map[aR][aC] != -1 && map[bR][bC]!=-1) {//3.
//			sum+=funcList[map[aR][aC]];//나누지만 합을 구하는거니까 한번 더하기
//		} else if(map[aR][aC] == -1 && map[bR][bC] != -1) {//1.
//			sum+=compare(aR,aC);
//			sum+=funcList()
//		}
//	}
}
