import java.util.Arrays;
import java.util.Scanner;

public class Q1065_silver4 {

	public static void main(String[] args) {
		// 양의 정수의 각 자리가 등차수열을 이루면 한수이다.
		// 한자리수일때 : 1234...9 = 9
		// 두자리수일때 : all! (99까지는 n개가 정답)
		// 세자리수일때 :
		// 100 :없음 (1-5) >> 1, 1, 2, 2, 3, 3, 4, 4, 5
		// 110 : 111
		// 120 : 123
		// 130 : 135
		// 140 : 147
		// 150 : 159
		// 160 : 없음 ...190까지 없음

		// 200 (1-5)
		// 210 : 210
		// 220 : 222
		// 230 : 234
		// 240 : 246
		// 250 : 258
		// 260 : 없음

		// 300 : 없음 (2-6)
		// 310 : X
		// 320 : 321
		// 330 : 333
		// 340 : 345
		// 350 : 357
		// 360 : 369

		// 400, 410 없음 (2-6)
		// 420 : 420
		// 430 ; 431
		// 440 : 444
		// 450 : 456
		// 460 : 468

		// 500, 510, 520 없음
		// 531, 543, 555, 567, 579,(3-7)

		// 600, 610, 620
		// 630, 642, 654, 666, 678,(3-7)

		// 700대도 5개
		// 741 752 765 777 789 (4-8) {4,5,6,7,8}

		// 800
		// 840 851 864 876 888 (4-8)

		// 900
		// 951 962 973 984 999 (5-9)

		// 1000 : 없음
		// 1~1000까지 99 + (5*9) = 144

		// CODE START!!

		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		// 어레이에 입력받은 수가 차례로 담김.
		int[] array = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			array[i] = str.charAt(i) - '0';
		}
		// 십의자리수가

		System.out.println(Arrays.toString(array));// 그냥 배열을 리턴하면 해당 배열이 저장된 메모리 주소를 출력함.

		// 두자리수까지는 그 수를 출력
		if (array.length < 3) {
			System.out.println(array[0] * 10 + array[1]);
		}
		// 세자릿수!!
		if (array.length == 3) {
			int hundreds = array[0];
			int tens = array[1];
			int ones = array[2];
			int answer = 99 + (array[0] - 1) * 5;

			// start를 기점으로 오름차순 수가 5개 있는 배열 생성하기
			int start = (int) Math.ceil((double) hundreds / 2);
			int[] ref = new int[5];
			for (int i = start; i < start + 5; i++) {
				ref[i - start] = i;
			}
			// 만약 십의자리수가 한수배열에 있으면
			if (Arrays.asList(ref).contains(tens)) {
				// 십의자리수를 고려하여 한수를 만들고
				int diff = hundreds - tens;
				array[2] = tens - diff;
				// int newHansu = String.join("", array);
				// int original = str
			} else {

			}

			// System.out.println(n);

		}
		// 세자릿수이면
		// 백의자리수 -1에 5를 곱한 수를 먼저 구하고
		// 십의자리수가 해당 백의자리수 한수배열에 있으면
		// 십의자리수를 고려하여 한수를 만들고 그 수가 현재수보다 작으면
		// indexof N+1
		// 그 수가 현재수보다 크면 indexof N을 더한다.
		// 십의자리수가 해당 백의자리수 한수배열에 없으면 패스
		// 763 99 + 30 +

	}

}
