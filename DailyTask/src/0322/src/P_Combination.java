
public class P_Combination {
    // 조합문제.
    // visited쓰고 idx 씀.
    static int[] nums;
    static boolean[] visited;
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
    static int M;

    public static void main(String[] args) {
        nums = new int[] { 1, 2, 3, 4, 5};
        M = 3;
        visited = new boolean[nums.length];
        Combination(0, 0);
        System.out.println(sb);
        System.out.println("cnt : " + cnt);
    }

    public static void Combination(int depth, int idx) {
        if (depth == M) {
            cnt++;
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    sb.append(nums[i] + " ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            visited[i] = true;
            Combination(depth + 1, i + 1);
            visited[i] = false;
        }
    }
}
