import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        System.out.println("test");
        int[] A = { 5, 4, 3, 2, 1 };

        for (int i = A.length - 1; 0 <= i; i--) {
            // j의 인덱스는 3까지 -> 2까지 -> 1 -> 0
            for (int j = 0; j < i; i++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(A));
    }
}
