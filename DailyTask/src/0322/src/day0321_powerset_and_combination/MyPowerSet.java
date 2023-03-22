package PS_2.day0321_powerset_and_combination;

import java.util.Stack;

public class MyPowerSet {

    public static int[] arr;
    public static int n, count;
    public static Stack<Integer> stack;

    public static void backTracking(int index) {
        if (index == n) {
            System.out.println(stack);
            count++;
            return;
        }
        // 선택한경우
        stack.push(arr[index]);
        backTracking(index + 1);
        stack.pop();
        // 선택 안한 경우
        backTracking(index + 1);
    }

    public static void main(String args[]) {
        n = 3;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        stack = new Stack<>();
        count = 0;
        backTracking(0);
        System.out.println(count);
    }

}