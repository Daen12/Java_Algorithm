
import java.util.Stack;

public class MyPerputation {

    public static int[] arr;
    public static int n, r, count;
    public static boolean[] visited;
    public static Stack<Integer> stack;

    public static void backTracking(int depth) {
        if (depth == r) {
            count++;
            print();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                stack.push(arr[i]);
                backTracking(depth + 1);
                stack.pop();
                visited[i] = false;
            }
        }
    }

    static void print() {
        for (int i : stack) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        // nPr 구하기
        n = 5;
        r = 3;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        stack = new Stack<>();
        visited = new boolean[n];
        count = 0;

        backTracking(0);
        System.out.printf("%dP%d = %d\n", n, r, count);
    }
}
