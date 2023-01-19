package Day1;

import java.util.Arrays;
import java.util.Scanner;

public class 실습4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("60갑자를 입력하세요 : ");
		String input = sc.next();
//
//		if(input.equals("종료")) {
//			break;
//		}

			String first = input.split("")[0];
			String second = input.split("")[1];

			String gan = "갑을병정무기경신임계";
			String zi = "자축인묘진사오미신유술해";
			int firstidx = gan.indexOf(first) + 1;
			int secondidx = zi.indexOf(second) + 1;

			// 십간에서 해당 입력값의 가능한 번호를 모두 배열화
			int[] firstArr = new int[6];
			for (int i = 0; i < 6; i++) {
				firstArr[i] = firstidx + 10 * i;
			}

			// 십이에서 해당 입력값의 가능한 번호를 모두 배열화
			int[] secondArr = new int[5];
			for (int i = 0; i < 5; i++) {
				secondArr[i] = secondidx + 12 * i;
			}

			// 십간과 십이지 배열 모두 돌면서 같은 번호 찾으면 멈추기
			// 여기서 같은 번호 = 1-60까지의 연도 중 해당 입력값이 어느 번째에 해당하는지
			// 만약 여기서 겹치는 숫자가 없으면 잘못입력한 것임.
			int addYear = 0;
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 5; j++) {
					if (firstArr[i] == secondArr[j]) {
						addYear = firstArr[i];
						break;
					}
				}
			}
//			if (addYear == 0) {
//				System.out.println("잘못된 입력");
//				break;
//			}

			// 1800년부터 2100년까지 연도 중 해당 연도 출력
			int finalYear = 1443 + addYear;

			while (finalYear < 2100) {
				finalYear += 60;
				if (1800 <= finalYear && 2100 >= finalYear) {
					System.out.print(finalYear + " ");
				}
			}
		}
	

	// 갑 : 1, 11, 21, 31, 41, 51, 중 하나
	// 을 : 2, 12, 22, 32, 42, 52, 중 하나
	// 병 : 3, 13, 23, 33, 43, 53, 중 하나
	// 자 : 1, 13, 25, 37, 49,
	// 축 : 2, 14, 26, 38, 50

	// 계 : 10, 20, 30, 40, 50, 60
	// 혜 : 12, 24, 36, 48, 60

}
