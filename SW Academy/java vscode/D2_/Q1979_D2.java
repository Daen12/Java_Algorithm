import java.util.Scanner;

class Q1979_D2 {
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
            // 가로
            int count = 0;
            for (int i = 0; i < N; i++) {
                int lengthCheck = 0;
                for (int j = 0; j < N; j++) {
                    // 만약에 해당 원소가 1이면
                    if (map[i][j] == 1) {
                        lengthCheck++;
                        if (lengthCheck == K)
                            count++;
                        if (lengthCheck > K)
                            count--;
                        lengthCheck = 0;
                    }
                }
            }
            // 세로
            for (int i = 0; i < N; i++) {
                int lengthCheck = 0;
                for (int j = 0; j < N; j++) {
                    // 만약에 해당 원소가 1이면
                    if (map[i][j] == 1) {
                        lengthCheck++;
                        if (lengthCheck == K)
                            count++;
                        if (lengthCheck > K)
                            count--;
                        lengthCheck = 0;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
