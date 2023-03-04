import java.util.Arrays;
import java.util.Scanner;

public class Q2628_종이자르기_silver5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(), H = in.nextInt(), n = in.nextInt();
        // 완전탐색 brute force
        // 가로의 최대 * 세로의 최대 = 전체 최댓값.
        int maxWidth = 0, maxHeight = 0;
        int[] widths = new int[n], heights = new int[n];
        int w = 0, h = 0;
        for (int i = 0; i < n; i++) {
            int dir = in.nextInt();
            if (dir == 0) { // 가로
                widths[w++] = in.nextInt();
            } else { // 세로
                heights[h++] = in.nextInt();
            }
        }
        Arrays.sort(widths); // 0 2 3
        Arrays.sort(heights); // 0 0 4

        int maxW = 0, maxH = 0;
        for (int i = 0; i < n; i++) {
            int cutW = 0, cutH = 0;
            // if (i == 0) {
            // cutW = widths[i];
            // cutH = heights[i];
            // } // 첫 인덱스
            if (i == n - 1) { // 끝 인덱스
                cutW = H - widths[i];
                cutH = W - heights[i];
            } else { // 중간인덱스
                cutW = widths[i + 1] - widths[i];
                cutH = heights[i + 1] - heights[i];
            }

            if (maxW < cutW)
                maxW = cutW;
            if (maxH < cutH)
                maxH = cutH;
        }
        System.out.println(maxW * maxH);
    }
}
