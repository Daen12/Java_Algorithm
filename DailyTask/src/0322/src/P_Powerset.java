public class P_Powerset {
    static int[] nums;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;

    public static void main(String[] args) {
        nums = new int[] { 1, 2, 3, 4};
        visited = new boolean[nums.length];
        powerSet(0);
        System.out.println(sb);
        System.out.println("cnt : " + cnt);
    }

    public static void powerSet(int idx) {
        if (idx == nums.length) {// 깊이가 배열의 수만큼 들어가면 모두 탐색한 것.
            cnt++;
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    sb.append(nums[i] + " ");
                }
            }
            sb.append("\n");
            return;
        }
        visited[idx] = true;
        powerSet(idx + 1);
        visited[idx] = false;
        powerSet(idx + 1);
    }
}
