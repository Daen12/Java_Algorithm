import java.util.Scanner;

class Q1979 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int K = in.nextInt();

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = in.nextInt();
                }
            }

            // 길이 k만큼만 1인 열의 갯수
            int count = 0;
            for (int i = 0; i < N; i++) {
                int lengthCheck = 0;
                for (int j = 0; j < N; j++) {
                    // 만약에 해당 원소가 1이면
                    if (map[i][j] == 1) {
                        for (int k = 0; k < K; k++) {
                            // 옆으로 K만큼 돌면서
                            // 1이면 lengthcheck
                            if (map[i][j + k] == 1) {
                                lengthCheck++;
                                // 만약 k=K-1까지 갔을때,
                                if (k == K - 1 && map[i][j + k + 1] == 1) {
                                    // k=K일때도 1이면 lengthCheck -1
                                    lengthCheck--;
                                }
                            } else
                                break; // 아니면 브레이크
                        }

                    }
                }
                // 만약 lengthcheck 결과가 K이면 count++
                if (lengthCheck == K)
                    count++;
            }
            for (int i = 0; i < N; i++) {
                int lengthCheck = 0;
                for (int j = 0; j < N; j++) {
                    // 만약에 해당 원소가 1이면
                    if (map[j][i] == 1) {
                        for (int k = 0; k < K; k++) {
                            // 옆으로 K만큼 돌면서
                            // 1이면 lengthcheck
                            if (map[j + k][i] == 1) {
                                lengthCheck++;
                                // 만약 k=K-1까지 갔을때,
                                if (k == K - 1 && map[j + k + 1][i] == 1) {
                                    // k=K일때도 1이면 lengthCheck -1
                                    lengthCheck--;
                                }
                            } else
                                break; // 아니면 브레이크
                        }

                    }
                }
                // 만약 lengthcheck 결과가 K이면 count++
                if (lengthCheck == K)
                    count++;
            }
        }

    }
}