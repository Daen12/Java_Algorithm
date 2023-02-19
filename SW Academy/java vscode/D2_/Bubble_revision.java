import java.util.Arrays;

public class Bubble_revision {
    public static void main(String[] args) {
        int[] A = { 5, 4, 3, 2, 1 };
        for (int i = A.length - 1; 0 <= i; i--) {
            for (int j = 0; j < i; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(A));
        }
        System.out.println(Arrays.toString(A));
    }
}
