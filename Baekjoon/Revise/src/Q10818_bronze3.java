import java.util.Arrays;
import java.util.Scanner;

public class Q10818_bronze3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int[] array = new int[num];
		for (int i = 0; i < num; i++) {
			array[i] = sc.nextInt();
		}

		// 내장메서드를 쓰는 방법! Arrays.sort()
		// Arrays.sort(array);
		//
		// System.out.println(array[0] + " " + array[num-1]);

		int min = array[0];
		int max = array[0];

		for (int i = 0; i < num; i++) {
			int target = array[i];

			if (min >= target) {
				min = target;
			}

			if (max <= target) {
				max = target;
			}
		}
		System.out.println(min + " " + max);

	}

}
