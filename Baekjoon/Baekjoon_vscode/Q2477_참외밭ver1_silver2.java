
import java.util.Scanner;

public class Q2477_참외밭ver1_silver2 {
    public static void main(String[] args) {
        // 1 = 2 / 3 = 4
        Scanner in = new Scanner(System.in);
        int T = in.nextInt(); // 면적당 참외의 개수
        int[] dir = new int[8];
        int[] size = new int[8];

        for (int i = 0; i < 6; i++) {
            dir[i] = in.nextInt();
            size[i] = in.nextInt();
        }
        dir[6] = dir[0];
        size[6] = size[0];
        dir[7] = dir[1];
        size[7] = size[1];

        int width = 0;
        int height = 0;
        for (int i = 0; i < 6; i++) {
            if (dir[i] == 1) {
                width += size[i];
            }
            if (dir[i] == 3) {
                height += size[i];
            }
        }
        int big = width * height;
        int small = 0;
        // 패인 직사각형의 넓이 구하기
        for (int i = 0; i < 7; i++) {
            if (dir[i] == 2 && dir[i + 1] == 4) {
                small = size[i] * size[i + 1];
            }
            if (dir[i] == 3 && dir[i + 1] == 2) {
                small = size[i] * size[i + 1];
            }
            if (dir[i] == 1 && dir[i + 1] == 3) {
                small = size[i] * size[i + 1];
            }
            if (dir[i] == 4 && dir[i + 1] == 1) {
                small = size[i] * size[i + 1];
            }
        }
        System.out.println((big - small) * T);
    }
}