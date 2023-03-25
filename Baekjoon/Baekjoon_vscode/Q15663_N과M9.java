import java.security.acl.LastOwnerException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Q15663_N과M9 {
    // 순열을 구하는 문제
    // 그런데 중복값이 존재
    // 순열은 isUsed가 있어야 하고, 전달인자로 인덱스가 없어도 됨.
    static int N, M;
    static int[] arr;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        isUsed = new boolean[N];
        Permutation(0);
        System.out.println(sb);
    }

    static void Permutation(int depth) {
        if (depth == M) {
            for (int i : stack) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        // M만큼 한라운드 돌고 갱신되면 초기화 해주기
        // 순열이 사전순이라 가능한 방법!
        int lastUsed = 0;
        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                if (arr[i] == lastUsed)
                    continue;
                stack.push(arr[i]);
                lastUsed = arr[i];
                isUsed[i] = true;
                Permutation(depth + 1);
                stack.pop();
                isUsed[i] = false;
            }
        }
    }

}
