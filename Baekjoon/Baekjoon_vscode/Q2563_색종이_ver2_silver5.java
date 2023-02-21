package solving_club;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q2563_색종이_ver2_silver5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		int[] x = new int[T];
		int[] y = new int[T];
		for (int t = 0; t < T; t++) {
			x[t] = in.nextInt();
			y[t] = in.nextInt();
		}
		//x [ 3, 15 5]
		//y [7, 7, 2]
		// (3,7) ~ (13, 17)

		int[][] coloredPapers = new int[100][100]; //0
		for (int i = 0; i < T; i++) {
			for (int r = y[i]; r < y[i]+10; r++) {
				for (int c = x[i]; c < x[i]+10; c++) {
					coloredPapers[r][c] = 1;
				}
			}
		}
		
		int area = 0;
		for(int r=0; r<100; r++) {
			for(int c=0; c<100; c++) {
				area+=coloredPapers[r][c];
			}
		}
		System.out.println(area);
	}
}
