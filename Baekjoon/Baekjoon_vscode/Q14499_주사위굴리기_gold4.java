import java.util.Arrays;
import java.util.Scanner;

public class Q14499_주사위굴리기_gold4 {
    // 주사위 방향에 따라
    // 모양변화 (방향 순서) 계산 후 배열 바꿔주고
    // 문제 조건 (숫자 묻는지)에 따라 차근차근 구현!

    static int[][] map;
    static int posR, posC, N, M;

    // [북,동,남,서,상,하]
    // 1 : [북,상,남,하,서,동] 0 4 2 5 3 1
    // 2 : [북,하,남,상,동,서] 0 5 2 4 1 3
    // 3 : [상,동,하,서,남,북] 4 1 5 3 2 0
    // 4 : [하,동,상,서,북,남] 5 1 4 3 0 2

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = in.nextInt();
        M = in.nextInt();

        map = new int[N][M];
        posR = in.nextInt();
        posC = in.nextInt();

        int orderN = in.nextInt();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                map[r][c] = in.nextInt();
            }
        }
        int[] dice = new int[6];
        // System.out.println(Arrays.toString(dice));
        for (int i = 0; i < orderN; i++) {
            int order = in.nextInt();
            switch (order) {
                case 1: // 동
                    posC++;
                    if (isOffGrid()) {
                        posC--;
                        break;
                    }
                    dice = new int[] { dice[0], dice[4], dice[2], dice[5], dice[3], dice[1] };
                    sb.append(dice[4] + "\n");
                    dice = printNum(dice, posR, posC);
                    break;
                case 2: // 0 5 2 4 1 3
                    posC--;
                    if (isOffGrid()) {// 지도에서 벗어났으면 초기화, 출력 X
                        posC++;
                        break;
                    }
                    dice = new int[] { dice[0], dice[5], dice[2], dice[4], dice[1], dice[3] };
                    sb.append(dice[4] + "\n");
                    dice = printNum(dice, posR, posC);
                    break;
                case 3:
                    posR--;
                    if (isOffGrid()) {// 지도에서 벗어났으면 초기화, 출력 X
                        posR++;
                        break;
                    }
                    dice = new int[] { dice[4], dice[1], dice[5], dice[3], dice[2], dice[0] };
                    sb.append(dice[4] + "\n");
                    dice = printNum(dice, posR, posC);
                    break;
                case 4:// 남 5 1 4 3 0 2
                    posR++;
                    if (isOffGrid()) {// 지도에서 벗어났으면 초기화, 출력 X
                        posR--;
                        break;
                    }
                    // 새로운 주사위 모습
                    dice = new int[] { dice[5], dice[1], dice[4], dice[3], dice[0], dice[2] };
                    sb.append(dice[4] + "\n");
                    dice = printNum(dice, posR, posC);
                    break;
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean isOffGrid() {
        return (posR < 0 || posC < 0 || posR >= N || posC >= M);
    }

    public static int[] printNum(int[] dice, int R, int C) {
        // 주사위 발바닥 = idx 5
        // 이동한 칸에 쓰여진 수가 0이 아니면 dice로 복사
        // 이동한 칸에 0이 쓰여졌으면 주사위 바닥의 수가 칸에 복사
        if (map[posR][posC] == 0) {
            map[posR][posC] = dice[5];
        } else {
            dice[5] = map[posR][posC];
            map[posR][posC] = 0;
        }
        return dice;
    }
}
