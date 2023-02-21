public class binary {
    public static void main(String[] args) {
        int[] A = { 2, 4, 5, 7, 9, 10, 13, 15 };
        int key = 10;
        int start = 0;
        int end = A.length - 1;
        int middle = start + end / 2;
        boolean flag = false;
        while (start <= end) {
            if (A[middle] == key) {
                flag = true;
                break;
            } else if (A[middle] > key) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
            middle = start + end / 2;
        }
        System.out.println(flag ? middle : -1);

    }
}
