import java.util.ArrayList;
import java.util.List;

public class powerset_bit {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 3 };
        List<Integer> list;
        int N = nums.length;
        for (int i = 0; i < (1 << N); i++) {
            list = new ArrayList<>();
            for (int j = 0; i < N; j++) {
                if ((i & (1 << j)) > 0) {
                    list.add(nums[j]);
                }
            }
            System.out.println(list);
        }
    }
}
