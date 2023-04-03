
import java.util.Stack;

public class MyCombinationWithRepetition {

    public static int[] arr;
    public static int n, r, count;
    public static Stack<Integer> stack;

    public static void backTracking(int depth, int index) {
        if (depth == r) {
            count++;
            print();
            return;
        }
        for (int i = index; i < n; i++) {
            stack.push(arr[i]);
            backTracking(depth + 1, i);
            stack.pop();
        }
    }

    static void print() {
        for (int i : stack){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        n = 6;
        r = 3;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        stack = new Stack<>();
        count = 0;

        backTracking(0, 0);
        System.out.printf("%dH%d = %d\n", n, r, count);
    }
}
