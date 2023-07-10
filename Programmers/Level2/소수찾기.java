import java.util.*;

public class 소수찾기 {
    // 소수 = 1과 자신 말고 나누어떨어지는 수가 없다는 뜻!
    static boolean[] visited;
    static Set<Integer> set;

    public static void main(String[] args) {
        String numbers = "011";
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        set = new HashSet<>();

        String[] nums = numbers.split("");
        for (int i = 1; i <= nums.length; i++) { // 소수 길이 1부터 끝까지!
            String[] arr = new String[i];// 담길 바구니
            boolean[] visited = new boolean[nums.length]; // visited check
            DFS(nums, i, 0, arr, visited);
        }
        // System.out.println(set.toString());
        return set.size();
    }

    public static void DFS(String[] nums, int n, int depth, String[] arr, boolean[] visited) {
        // 주어진 숫자들로 n개 순열 뽑기
        // Integer.parseInt
        if (depth == n) {
            String t = "";
            for (int i = 0; i < arr.length; i++) {
                t += arr[i];
            }
            int T = Integer.parseInt(t);
            boolean isSosu = true;
            for (int i = 2; i < T; i++) {
                if (T % i == 0)
                    isSosu = false;
            }
            if (isSosu && T != 1 && T != 0) {
                set.add(T);
            }
            return;
        }

        // 1, 7
        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;

            arr[depth] = nums[i];
            visited[i] = true;
            DFS(nums, n, depth + 1, arr, visited);
            visited[i] = false;

        }

    }
}
