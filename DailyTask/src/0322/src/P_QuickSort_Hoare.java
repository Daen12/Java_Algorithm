import java.util.Arrays;

public class P_QuickSort_Hoare {
    static int[] arr;

    public static void main(String[] args) {
        arr = new int[] { 10, 9, 35, 2, 88, 3, 33, 37 };
        QuickSort(0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void QuickSort(int left, int right) {
        if (left >= right)
            return;

        int pivot = HoarePartition(left, right);
        QuickSort(left, pivot - 1);
        QuickSort(pivot + 1, right);
    }

    public static int HoarePartition(int left, int right) {
        int pivot = arr[left];
        int L = left + 1;
        int R = right;
        while (L <= R) {
            while (L <= R && arr[L] <= pivot) {
                L++;
            }
            while (arr[R] > pivot) {
                R--;
            }
            if (L < R) {
                int temp = arr[L];
                arr[L] = arr[R];
                arr[R] = temp;
            }
        }
        // if escaped the loop,
        // L pointer has passed R pointer. swap R value with the pivot
        // because R rests in the right-most index of values that are equal to | smaller than pivot.
        int temp = arr[R];
        arr[R] = arr[left];
        arr[left] = temp;

        return R;
    }

}