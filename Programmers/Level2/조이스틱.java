import java.util.Arrays;

public class 조이스틱 {
    // ABCDEFGHIJKLMNOPQRSTUVWXYZ
    // 13 2 9
    // static int[] nums;
    // static int plus = 0;
    // static int minus = 0;
    // static int minCnt = Integer.MAX_VALUE;

    public static void main(String[] args) {
        String name = "JEROEN";
        // BBBBAAAABA
        System.out.println(Solution(name));
    }
    // 1011 1101 1001 101010 10010101
    // (왼쪽이동시 인덱스0 빼고 마지막 1이 어딘지 vs 오른쪽 이동 시 마지막 1)

    public static int Solution(String name) {
        char[] alphabet = name.toCharArray();
        int move = name.length() - 1; // 오른쪽으로만 이동 시

        int[] nums = new int[name.length()];
        for (int i = 0; i < name.length(); i++) {
            nums[i] = alphabet[i] - 65;
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 13) {
                ans += nums[i];
            } else {
                ans += (26 - nums[i]);
            }
            // A의 마지막 위치 구하기
            int lastA = i + 1;
            while (lastA < nums.length && nums[lastA] == 0) {
                lastA++;
            }
            // 좌우 이동
            move = Math.min(move, i + (nums.length - lastA) + Math.min(i, nums.length - lastA));

        }
        return ans + move;
    }

    // public static void DFS(int i, int depth, int[] ansArr, int cnt) {
    // ansArr[i] = nums[i];

    // if (Arrays.toString(ansArr).equals(Arrays.toString(nums))) {
    // minCnt = Math.min(minCnt, cnt);
    // return;
    // }
    // if (depth == nums.length) {
    // return;
    // }
    // if (i == nums.length - 1) {
    // plus = 0;
    // } else {
    // plus = ++i;
    // }
    // if (i == 0) {
    // minus = nums.length - 1;
    // } else {
    // minus = --i;
    // }
    // System.out.println(plus + " " + minus);
    // DFS(plus, depth + 1, ansArr, cnt + 1);
    // DFS(minus, depth + 1, ansArr, cnt + 1);
    // }
    // int move1 = 0;
    // int[] numCopy = nums.clone();
    // int[] ansArr1 = new int[nums.length];
    // for (int i = 0; i < numCopy.length; i++) {
    // ansArr1[i] = nums[i];
    // if (Arrays.toString(ansArr1).equals(Arrays.toString(nums))) {
    // break;
    // }
    // move1++;
    // }
    // int move2 = 0;
    // ansArr1 = new int[nums.length];
    // ansArr1[0] = nums[0];
    // for (int i = nums.length - 1; i >= 1; i--) {
    // move2++;
    // ansArr1[i] = nums[i];
    // if (Arrays.toString(ansArr1).equals(Arrays.toString(nums))) {
    // break;
    // }
    // }
    // int move = Math.min(move1, move2);
}
