import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q15656_N과M7 {
    // Permutation with repetition
    // isUsed가 없어도 되고
    // 스택을 활용해보기
    // 순열이므로 인덱스 인자로 받지 않아도 됨.

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
        Permutation_W_Repetition(0);
        System.out.println(sb);
    }

    public static void Permutation_W_Repetition(int depth) {
        if (depth == M) {
            for (int i : stack) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return; // 리턴 꼭 해주어야함!!
        }
        for (int i = 0; i < N; i++) {
            stack.add(arr[i]);
            Permutation_W_Repetition(depth + 1);
            stack.pop();
        }
    }
}
