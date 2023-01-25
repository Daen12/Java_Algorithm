package Day1;

import java.util.Scanner;

public class 실습3_3 {

	// 가위 1 주먹 2 보 3
	// 1>3
	// 2>1
	// 3>2
	// 호출시마다 게임을 수행하는 함수 만들기
	public static String game() {
		Scanner sc = new Scanner(System.in);
		System.out.print("가위바위보 중 하나 입력 : ");
		String input = sc.next();
		// 가위 주먹 보를 숫자로 환산
		int user = 0;
		user = input.equals("가위") ? 1 : input.equals("바위") ? 2 : 3;

		// 컴퓨터의 숫자를 받기
		int computer = (int) (Math.random() * 3) + 1;
		System.out.println(computer);

		// 게임의 결과를 결정하기
		String result = "";
		if (user == computer) {
			result = "tie";
		} else if ((user == 1 || computer == 1) && (user == 3 || computer == 3)) {
			result = user > computer ? "lose" : "win";
		} else {
			result = user > computer ? "win" : "lose";
		}
		System.out.println(result);
		return result;

	}

	// 게임 진행하는 함수 만들기
	public static void decision(int num, int w) {
		int win = 0;
		int lose = 0;
		int gameCount = 0;

		for (int i = 0; i < num; i++) {
			String result = game();
			if (result.equals("win")) {
				win++;
			} else if (result.equals("lose")) {
				lose++;
			}
			gameCount++;

			if (win == w) {
				System.out.println("### 유저 승!!!");
				break;
			}
			if (lose == w) {
				System.out.println("### 컴퓨터 승!!!");
				break;
			}

			if (gameCount == num) {
				System.out.println("### 주어진 횟수를 소진하여 게임을 종료합니다.");
			}

		}
	}

	// 처음 게임을 선택하고 함수 시행하는 main함수
	public static void main(String[] args) {
		// 이길 때, 질 때, 비길 때 세가지 조건문만 사용하기
		Scanner sc = new Scanner(System.in);
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요");
		System.out.println("\n1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.print("\n번호를 입력하세요 : ");

		int gameChoice = sc.nextInt();
		if (gameChoice == 1) {
			decision(5, 3);
		} else if (gameChoice == 2) {
			decision(3, 2);
		} else {
			decision(1, 1);
		}

	}

}
