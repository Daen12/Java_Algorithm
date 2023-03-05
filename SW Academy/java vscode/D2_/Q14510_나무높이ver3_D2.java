import java.util.Scanner;

public class Q14510_나무높이ver3_D2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt(); // 나무의 개수
            int[] trees = new int[N];
            int max = 0;
            for (int n = 0; n < N; n++) { // 높이의 최댓값 구하면서 배열화
                trees[n] = in.nextInt();
                if (trees[n] > max)
                    max = trees[n];
            }

            int totalDiffs = 0;
            int mod0Nums = 0, mod1Nums = 0, mod2Nums = 0;
            for (int i = 0; i < N; i++) {
                int diff = max - trees[i]; // 각각의 차이에 대해서
                totalDiffs += (2 * (diff / 3) + (diff % 3)); // 필요한 날들 total에 더해주기
                if (diff % 3 == 1) { //
                    mod1Nums++;
                }
                if (diff % 3 == 2) {
                    mod2Nums++;
                }
            }
            // 총 자라는 길이 = 3 * m + (1 or 2) => 나머지가 2이면 그사이에 1 채워줄 수 있음.
            int smaller = Math.min(mod1Nums, mod2Nums);
            int bigger = Math.max(mod1Nums, mod2Nums);

            // 1이 있으면 2를 더해야 하는데 1만 추가로 더하게 됨.
            // 따라서 나머지 2의 개수 - 1의개수 +(남은 1의 개수) 해주어야 함.

            int m = totalDiffs / 3;
            int n = totalDiffs % 3;
            // int result = ones >= mod2Nums ? 2 * m + n + ones - mod2Nums : 2 * m + n;

            System.out.printf("#%d %d\n", t, totalDiffs - smaller);
        }
    }
}
