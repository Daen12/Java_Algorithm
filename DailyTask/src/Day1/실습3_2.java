package Day1;

public class 실습3_2 {
	public static void main(String[] args) {
		int num = 1;
		String space = "   ";
		for (int i = 0; i < 5; i++) {
			// i-2의 절댓값 *2 +1 만큼 숫자를 쓴다.
			// 5-(위의 식)/2만큼 공백이 생긴다.

			int flag = Math.abs(i - 2) * 2 + 1;

			for (int j = 0; j < Math.abs((5 - flag) / 2); j++) {
				System.out.print(space);
			}
			for (int k = 0; k < flag; k++) {
				System.out.printf("%-3s", num);
				num++;
			}
			System.out.println();
		}
	}

}
