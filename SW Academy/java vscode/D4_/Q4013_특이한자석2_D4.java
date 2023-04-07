import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q4013_특이한자석2_D4 {
	// 자석1 2번 = 자석2 6번
	// 자석2 2번 = 자석3 6번
	// 자석3 2번 = 자석4 6번

	// 자석2와 자석4는 거꾸로 읽어서 배열화하기 =
	// 자석1 2번 = 자석2 2번
	// 자석2 6번 = 자석3 6번
	// 자석3 2번 = 자석4 2번
	// 각 인덱스 체크해서 값이 다르면 같은 방향으로 돌려주기.

	static int[] first, second, third, fourth;
	static int[][] All = new int[4][8];
	static int K, ans;
	static int[] move;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			first = new int[8];
			second = new int[8];
			third = new int[8];
			fourth = new int[8];
			K = in.nextInt();
			for (int i = 0; i < 8; i++) {
				first[i] = in.nextInt();
			}
			for (int i = 0; i < 8; i++) {
				second[i] = in.nextInt();
			}
			reverse(second);
			for (int i = 0; i < 8; i++) {
				third[i] = in.nextInt();
			}
			for (int i = 0; i < 8; i++) {
				fourth[i] = in.nextInt();
			}
			reverse(fourth);
			All = new int[][] { first, second, third, fourth };
			int[] magnet = new int[K];
			int[] dir = new int[K];
			for(int[] line : All) {
				System.out.println(Arrays.toString(line));
			}
			for (int i = 0; i < K; i++) {
				// 함수 짜서 각 자석과 방향으로 실행
				int arr = in.nextInt() - 1;
				int dir2 = in.nextInt();
				turn(arr, dir2);
			}
			ans = 0;
			if(All[0][0] == 1) ans+=1;
			if(All[1][0]==1) ans+=2;
			if(All[2][0]==1) ans+=4;
			if(All[3][0]==1) ans+=8;
			
			System.out.printf("#%d %d\n", t, ans);
		}
	}

	public static void turn(int arr, int dir) {
		// 어느 톱니바퀴가 맞물려있는지
		move = new int[3];
		if (All[0][2] != All[1][2])
			move[0] = 1;
		if (All[1][6] != All[2][6])
			move[1] = 1;
		if (All[2][2] != All[3][2])
			move[2] = 1;
		if (dir == 1) {// 시계방향
			rightTurn(arr);
		} else {
			leftTurn(arr);
		}

	}

	public static void rightTurn(int arr) {
		if (arr == 0) {// 첫번째 톱니바퀴이면
			All[arr] = clockWise(All[arr]);
			for (int i = 0; i < 3; i++) {// 2,3,4번 톱니바퀴 보면서
				if (move[i] == 1) {
					All[i + 1] = clockWise(All[i + 1]);
				} else {// 0이면 나머지 안돌려도 됨.
					break;
				}
			}
		} else if (arr == 1) {// 두번째 톱니바퀴이면
			All[arr] = clockWise(All[arr]);
			if(move[0]==1) {//첫번째 확인
				All[0] = clockWise(All[0]);
			}
			for (int i = 1; i < 3; i++) {//세네번째 확인
				if (move[i] == 1) {
					All[i + 1] = clockWise(All[i+1]);
				} else {
					break;
				}
			}
		} else if (arr == 2) {// 세번째 톱니바퀴이면 
			All[arr] = clockWise(All[arr]);
			if (move[2] == 1) {
				All[3] = clockWise(All[3]);
			}
			for(int i=1; 0<=i; i--) {
				if(move[i]==1) {
					All[i] = clockWise(All[i]);
				}
			}
		} else {//네번째 톱니바퀴이면
			All[arr] = clockWise(All[arr]);
			for(int i=2; 0<=i; i--) {
				if(move[i]==1) {
					All[i] = clockWise(All[i]);
				}
			}
		}
	}

	public static void leftTurn(int arr) {
		if (arr == 0) {// 첫번째 톱니바퀴이면
			All[arr] = counterClock(All[arr]);
			for (int i = 0; i < 3; i++) {// 2,3,4번 톱니바퀴 보면서
				if (move[i] == 1) {
					All[i + 1] = counterClock(All[i + 1]);
				} else {// 0이면 나머지 안돌려도 됨.
					break;
				}
			}
		} else if (arr == 1) {// 두번째 톱니바퀴이면
			All[arr] = counterClock(All[arr]);
			if(move[0]==1) {//첫번째 확인
				All[0] = counterClock(All[0]);
			}
			for (int i = 1; i < 3; i++) {//세네번째 확인
				if (move[i] == 1) {
					All[i + 1] = counterClock(All[i+1]);
				} else {
					break;
				}
			}
		} else if (arr == 2) {// 세번째 톱니바퀴이면 
			All[arr] = counterClock(All[arr]);
			if (move[2] == 1) {
				All[3] = counterClock(All[3]);
			}
			for(int i=1; 0<=i; i--) {
				if(move[i]==1) {
					All[i] = counterClock(All[i]);
				}
			}
		} else {//네번째 톱니바퀴이면
			All[arr] = counterClock(All[arr]);
			for(int i=2; 0<=i; i--) {
				if(move[i]==1) {
					All[i] = counterClock(All[i]);
				}
			}
		}
	}

	public static int[] clockWise(int[] arr) {
		int[] temp = arr.clone();
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i + 1] = temp[i];
		}
		arr[0] = temp[arr.length - 1];// 맨뒤의 원소!
		return arr;
	}

	public static int[] counterClock(int[] arr) {
		int[] temp = arr.clone();
		for (int i = 1; i < arr.length; i++) {
			arr[i - 1] = temp[i];
		}
		arr[arr.length - 1] = temp[0];// 맨뒤의 원소!
		return arr;
	}

	public static void reverse(int[] arr) {
		// 18765432 -> 12345678
		int[] temp = arr.clone();
		for (int i = 1; i < arr.length; i++) {
			arr[i] = temp[8 - i];
		}
	}
}
