import java.util.Scanner;

public class Q14510_나무높이_D2 {
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
            int mod0Total = 0, mod1Total = 0, mod2Total = 0;
            for (int i = 0; i < N; i++) {
                int diff = max - trees[i];
                totalDiffs += diff;
                if (diff % 3 == 1) { // 3으로 나눈 나머지에 따라 나누기
                    mod1Total += diff;
                    mod1Nums++;
                }
                if (diff % 3 == 2) {
                    mod2Total += diff;
                    mod2Nums++;
                }
                if (diff % 3 == 0) { // 3으로 나누어 떨어지므로, /3한 몫이 정답++
                    mod0Total += diff;
                    mod0Nums++;
                }
            }
            // 총 자라는 길이 = 3 * m + (1 or 2) => 나머지가 2이면 그사이에 1 채워줄 수 있음.
            // 나머지가 2인 개수 = 나머지가 1인 개수만큼 계산

            int smaller = Math.min(mod1Nums, mod2Nums);
            int bigger = Math.max(mod1Nums, mod2Nums);
            int add = 0;
            if (bigger == mod1Nums) { // 만약에 1이 남으면
                totalDiffs -= mod1Nums;
                add = (mod1Nums - 1) * 2 + 1;
            }
            int m = totalDiffs / 3;
            int n = totalDiffs % 3;
            // int modDiff = 0;
            // if (mod1Nums > mod2Nums) {
            // modDiff = mod1Nums - mod2Nums;
            // }

            // if(bigger == mod2Nums){

            // }
            // 아니면
            // int result = ones >= mod2Nums ? 2 * m + n + ones - mod2Nums : 2 * m + n;

            System.out.printf("#%d %d\n", t, (2 * m + n) + add);
        }
    }
}
