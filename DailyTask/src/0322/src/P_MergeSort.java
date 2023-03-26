import java.util.Arrays;

public class P_MergeSort {
    static int[] arr;
    static int[] temp;

    public static void main(String[] args) {
        arr = new int[] { 10, 9, 35, 2, 88, 3, 33, 37 };
        temp = new int[arr.length];
        MergeSort(0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void MergeSort(int left, int right) {
        if (left >= right)
            return;

        int mid = (left + right) / 2;
        MergeSort(left, mid);
        MergeSort(mid + 1, right);
        Merge(left, mid, right);
    }

    public static void Merge(int left, int mid, int right) {
        int idx = left;
        int L = left;
        int R = mid + 1;
        while (L <= mid && R <= right) {
            if (arr[L] <= arr[R]) {// if the value in left part is smaller
                temp[idx++] = arr[L++];
            } else {// if the value in right part is smaller
                temp[idx++] = arr[R++];
            }
        }
        // out of loop = at least one part has fullfilled value check!
        if (L <= mid) {// if the left part has value left
            for (int i = L; i <= mid; i++) {
                temp[idx++] = arr[i];
            }
        } else {// if the right part has value left
            for (int i = R; i <= right; i++) {
                temp[idx++] = arr[i];
            }
        }
        // end of sort.
        // copy all values in temp array into original array
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }

}