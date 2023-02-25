import java.time.chrono.MinguoDate;
import java.util.Arrays;
import java.util.Scanner;

public class Q2477_참외밭_silver2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt(); // 면적당 참외의 개수
        int[] dir = new int[6];
        int[] size = new int[6];
        // 방향과 사이즈 넣어주기
        for (int i = 0; i < 6; i++) {
            dir[i] = in.nextInt();
            size[i] = in.nextInt();
        }

        int width = 0;
        int height = 0;
        int[] count = new int[5];
        // 최대 높이와 넓이 구하기
        for (int i = 0; i < 6; i++) {
            if (dir[i] == 1) {
                width += size[i];
            }
            if (dir[i] == 3) {
                height += size[i];
            }
            count[dir[i]]++;
        }
        // 큰 직사각형의 넓이
        int big = width * height;
        // 두번 나오는 방향 구하기 -> 배열화
        int[] minIdx = new int[2];
        for (int i = 0, j = 0; i < 5; i++) {
            if (count[i] == 2) {
                minIdx[j++] = i;
            }
        }
        // 두번 나오는 방향의 숫자 비교해서 더 작은숫자 mins에 넣기
        int[] mins = new int[2];
        for (int i = 0, k = 0; i < minIdx.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < 6; j++) {
                if (dir[j] == minIdx[i] && min > size[j]) {
                    min = size[j];
                }
            }
            mins[k++] = min;
        }
        // mins의 두 숫자 곱하면 작은 직사각형
        int small = mins[0] * mins[1];
        System.out.println((big - small) * T);
    }
}
