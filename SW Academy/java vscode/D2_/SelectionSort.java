import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] A = { 7, 3, 4, 8, 6 };
        for (int i = 0; i < A.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[minIdx] > A[j])
                    minIdx = j;
            }
            // swap
            int temp = A[i];
            A[i] = A[minIdx];
            A[minIdx] = temp;
            System.out.println(Arrays.toString(A));
        }

        System.out.println(Arrays.toString(A));
    }
}
