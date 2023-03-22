package solving_club;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q보호필름 {
	static int[][] Films;
	static int[][] FilmCopy;
	static int R, C, K;
	static int min;
	static List<Integer[]> list = new ArrayList<>();
//	static int[] list;
//	static boolean[] select;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			R = in.nextInt(); //6
			C = in.nextInt(); //8
			K = in.nextInt();
			Films = new int[R][C];
//			list = new int[(int) Math.pow(2, R)];
//			select = new boolean[R];
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					Films[r][c] = in.nextInt();
				}
			}
			min = Integer.MAX_VALUE;
			partialSet(); //배열에 가능한 부분집합 넣어주기.
			
			for(int i=1; i<list.size(); i++) {//64경우
				if(check()) {
					break;
				} else {
					FilmCopy = Films;
					change(list.get(i));
					//요기서 함수를 호출하는데, 
					//이 함수는 배열을 받아서
					//A로 바꿀지 B로 바꿀지 결정
				}
			}
			for(Integer[] l : list) {
				System.out.println(Arrays.toString(l));
			}
			System.out.println(list.size());
//			System.out.println(list);
			System.out.printf("#%d %b\n", t, min);
		}
	}
	public static void change(Integer[] arr) {//부분집합 구하기
//		for(int i =0; i)
	
		
	}
	public static void partialSet() { 
		for(int i=0; i<(1<<R); i++) {//6에 대한 모든 부분집합의 수
			int[] arr = new int[R];
			for(int j=0; j<R; j++) {
				if((i&(1<<j))>0) {//j번째와 일치한다는 뜻.
					arr[j] = 1;
				}
			}
			int cnt = 0;
			for(int k=0; k<R; k++) {//배열에 있는 1의 개수 구하기
				if(arr[k] == 1) {
					cnt++;
				}
			}
			int[] indexes = new int[cnt];
			int idx = 0;
			for(int k=0; k<R; k++) {
				if(arr[k] == 1) {
					indexes[idx++] = k;
				}
			}
			Integer b[] = Arrays.stream(indexes).boxed().toArray(Integer[]::new);
			list.add(b); //리스트에 부분집합을 담기!
		}
	}

	
	public static boolean check() {//3
		int colComplete = 0;
		for(int r=0; r<C; r++) {
			int flag = -1;
			int countA = 0;
			int countB = 0;
			for(int c=0; c<R; c++) {
				if(c==0) {
					flag = Films[0][r];
				}
				if(flag != Films[c][r]) {
					countA = 0;
					countB = 0;
					flag = Films[c][r];
				}
				if(Films[c][r] == 0 && flag == 0) {
					countA++;
					if(countA == K) {
						colComplete++;
						break;
					}
				} else if(Films[c][r] == 1 && flag == 1){
					countB++;
					if(countB==K) {
						colComplete++;
						break;
					}
				} 
			}
		}
		//만약 colComplete의 값이 칼럼개수와 일치하면 모두 통과한것이므로 리턴 true
		if(colComplete == C) {
			return true;
		} else {
			return false;
		}
	}
}
