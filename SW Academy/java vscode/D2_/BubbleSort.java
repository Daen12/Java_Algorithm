
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        int N = arr.length;

        System.out.println("시작 전 :" + Arrays.toString(arr));
        for (int i = 0; i < N - 1; i++) { // 이렇게 하면 n-2번 반복
            for (int j = 0; j < N - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
            System.out.printf("%d번째 패스 결과 : %s\n", i + 1, Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }
}
