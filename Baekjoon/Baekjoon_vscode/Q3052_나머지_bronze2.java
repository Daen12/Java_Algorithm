package solving_club;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Q3052_나머지_bronze2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] count = new int[42];
		for(int i=1; i<=10; i++) {
			count[in.nextInt()%42]++;
		}
		//count배열에서 0이 아니면 count++
		int sum = 0;
		System.out.println(Arrays.stream(count).filter(c-> c!=0).count());

	}
}
