import java.util.Arrays;

public class P_Permutation_error {
    static int[] nums;
    static boolean[] isUsed;
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
    static int M;

    public static void main(String[] args) {
        nums = new int[] { 1, 2, 3, 4, 5, 6 };
        M = 3;
        isUsed = new boolean[nums.length];
        Permutation(0);
        System.out.println(sb);
        System.out.println("cnt : " + cnt);
    }

    public static void Permutation(int depth) {
        if (depth == M) {
            System.out.println(Arrays.toString(isUsed));
            cnt++;
            for (int i = 0; i < nums.length; i++) {
                if (isUsed[i]) {
                    sb.append(nums[i] + " ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!isUsed[i]) {
                // arr[depth] = nums[i];
                isUsed[i] = true;
                Permutation(depth + 1);
                isUsed[i] = false;
            }
        }
    }

}
