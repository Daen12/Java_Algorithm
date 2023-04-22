    import java.util.Scanner;

    public class Q12865_평범한배낭_1차원DP_gold5 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);

            //아이템 개수 N, 가방무게 최대 W
            int n = in.nextInt();
            int W = in.nextInt();
            int[]weights = new int[n+1];
            int[]cost = new int[n+1];

            for(int i=1; i<=n; i++) {
                weights[i] = in.nextInt();
                cost[i] = in.nextInt();
            }
            int[][]dp = new int[n+1][W+1];
            //아이템 한개씩 늘려가며 고려

            for(int i=1; i<=n; i++) {
                //각 아이템을 이용하여 최적해 갱신!
                for(int w=0; w<=W; w++) {
                    if(weights[i]<=w) {
                        //현재 고려하는 무게가 i번째 아이템의 무게보다 작다면
                        //지금까지의 최적해 (w의 최대가치 들어있는 값)는 dp[i-1][w]
                        //이번에 고려하는 최적해는 dp[i-1][w-weights[i]]+cost[i]
                        //인덱스 에러 주의. i는1부터 시작!
                        //따라서 원칙적으로 i=0인 배열을 0으로 초기화해주어야 함.
                        dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i]]+cost[i]);

                    } else {
                        dp[i][w] = dp[i-1][w]; //현재 임시무게가 지금의 아이템 담을 수 없음 -> 고려 제외!
                    }
                }
            }
            System.out.println(dp[n][W]);
        }
    }

