import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q15657_N과M8 {
    // Combination with Repetition
    // isUsed 없어도 됨
    // 조합이니까 인덱스 인자로 받아야 함.
    // stack이랑 stringbuilder로 쓰기

    static int N, M;
    static int[] arr;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        Combination_W_Repetition(0, 0);
        System.out.println(sb);
    }

    public static void Combination_W_Repetition(int depth, int idx) {
        if (depth == M) {
            for (int i : stack) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = idx; i < N; i++) {
            stack.push(arr[i]);
            Combination_W_Repetition(depth + 1, i);
            stack.pop();
        }
    }
}
