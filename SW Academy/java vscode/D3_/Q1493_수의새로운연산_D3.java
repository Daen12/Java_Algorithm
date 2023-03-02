import java.util.Arrays;
import java.util.Scanner;

import javax.xml.transform.Templates;

class Q1493_수의새로운연산_D3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N1 = in.nextInt();
            int N2 = in.nextInt();
            int[] grid1 = numToGrid(N1);
            int[] grid2 = numToGrid(N2);
            int y1 = grid1[1] - N1 + 1;
            int x1 = N1 - grid1[2];
            int y2 = grid2[1] - N2 + 1;
            int x2 = N2 - grid2[2];

            int newX = x1 + x2;
            int newY = y1 + y2;

            int newLoop = newX + newY - 1;
            // newLoop까지 acc한 수 + newX의 좌표 = 구하는 수
            int acc = 0;
            int temp = 0;
            while (temp < newLoop - 1) { // 3
                temp++;
                acc += temp;
            }
            System.out.printf("#%d %d\n", t, acc + newX);
        }
    }

    public static int[] numToGrid(int N) { // 5
        int[] grid = new int[3];
        int loop = 0; // 몇번째?
        int acc = 0; // loop의 누적값
        while (true) {
            loop++;
            acc += loop;
            if (N <= acc) {
                grid[0] = loop;
                grid[1] = acc;
                grid[2] = acc - loop;
                return grid;
            }
        }
    }
}