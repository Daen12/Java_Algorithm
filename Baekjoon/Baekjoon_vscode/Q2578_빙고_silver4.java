import java.util.Arrays;
import java.util.Scanner;

public class Q2578_빙고_silver4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] bingo = new int[5][5];
        boolean[][] isBingo = new boolean[5][5]; // all false
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                bingo[r][c] = in.nextInt();
            }
        }
        int[] numbers = new int[25];
        for (int i = 0; i < 25; i++) {
            numbers[i] = in.nextInt();
        }
        // 숫자 하나씩 부르면 지우기.
        int num = 0; // 그전에 불렀던 숫자들에 대한 빙고수가 누적되어있음.
        int result = 0;
        boolean diag1called = false;
        boolean diag2called = false;
        outer: for (int k = 0; k < 25; k++) {
            int number = numbers[k];
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if (bingo[r][c] == number) {
                        isBingo[r][c] = true; // 해당 칸 true로 바꾸기
                        // 이미 부른 숫자에 대해선 다시 안부름
                        // 가로 세로 확인
                        int BingoX = 1, BingoY = 1, diag1 = 1, diag2 = 1;
                        boolean isBingoX = true, isBingoY = true, isdiag1 = true, isdiag2 = true;
                        for (int i = 0; i < 5; i++) {
                            if (!isBingo[i][c]) {
                                isBingoY = false;
                                BingoY = 0;
                                break;
                            }
                        }
                        for (int j = 0; j < 5; j++) {
                            if (!isBingo[r][j]) {
                                isBingoX = false;
                                BingoX = 0;
                                break;
                            }
                        }
                        // 대각선은 중복되면 안댐.
                        for (int d1 = 0; d1 < 5; d1++) {
                            if (!isBingo[d1][d1]) {
                                isdiag1 = false;
                                diag1 = 0;
                                break;
                            }
                        }

                        for (int d2 = 0; d2 < 5; d2++) {
                            if (!isBingo[d2][4 - d2]) {
                                isdiag2 = false;
                                diag2 = 0;
                                break;
                            }
                        }
                        if (isBingoX)
                            num += BingoX;
                        if (isBingoY)
                            num += BingoY;
                        if (isdiag1 && !diag1called) {
                            num += diag1;
                            diag1called = true;
                        }
                        if (isdiag2 && !diag2called) {
                            num += diag2;
                            diag2called = true;
                        }
                        if (num >= 3) {
                            result = k + 1;
                            break outer; // 입력 다 안받고 break 가능?
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
