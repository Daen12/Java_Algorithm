
import java.util.ArrayList;
import java.util.List;

public class powerset_bitmasking {
    static int[] nums = new int[] { 0, 1, 2, 3 };

    public static void main(String[] args) {
        int N = nums.length;
        for (int i = 0; i < (1 << N); i++) { // 16가지의 경우의 수
            List<Integer> list = new ArrayList<>();
            for (int j = 0; i < N; j++) {
                if ((i & (1 << j)) > 0) {
                    list.add(nums[j]);
                }
            }
            System.out.println("here!");
            System.out.println(list);
        }
    }
}