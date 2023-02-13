
import java.util.Arrays;
import java.util.Scanner;

public class Q1289 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();

		for (int i = 0; i < T; i++) {
			// 여기서 연산 시행
			String memory = in.next();
			int count = 0;
			int len = memory.length();
			// 먼저 1로 시작하는 부분부터 배열에서 자른 후에
			// 양옆이 서로 같은 숫자들만큼 전체 길이에서 빼기!!
			// 일단 메모리의 각 글자를 배열에 넣기.

			char[] array = memory.toCharArray();

			// 앞의 0의 개수를 세주기
			int zeros = 0;
			while (array[zeros] == '0') {
				++zeros;
			}
			char copy[] = Arrays.copyOfRange(array, zeros, len);

			for (int j = 0; j < copy.length - 1; j++) {
				if (copy[j] == copy[j + 1])
					count++;
			}
			System.out.println("#" + (i + 1) + " " + (copy.length - count));
		}
	}
}
