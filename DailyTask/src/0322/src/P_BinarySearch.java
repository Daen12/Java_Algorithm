import java.util.Arrays;

public class P_BinarySearch {
    static int[] arr;
    static int key;

    public static void main(String[] args) {
        arr = new int[] { 3, 66, 8, 23, 33, 37, 5 };
        Arrays.sort(arr);
        key = 33;
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(0, arr.length - 1));

    }

    public static int binarySearch(int start, int end) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] > key) {
            return binarySearch(start, mid - 1);
        } else {
            return binarySearch(mid + 1, end);
        }
    }

}
