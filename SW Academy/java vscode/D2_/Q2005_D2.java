import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q2005 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int height = in.nextInt();
            System.out.println("#" + (t + 1));

            // 각각의 층에 대해서
            int[] reference = new int[10];
            for (int i = 1; i <= height; i++) {
                // 더미 배열 생성
                int[] arr = new int[i];
                // 각 원소에 대해서
                for (int j = 0; j < i; j++) {
                    // 처음이나 끝은 1주고
                    if (j == 0 || j == i - 1) {
                        arr[j] = 1;
                    } else {
                        // 중간값들에 대해서 reference 참고해서 만들기!
                        arr[j] = reference[j - 1] + reference[j];
                    }
                }

                // 포문..다 돈 다음에....프린트하세요... 30분 날리기 싫으면,,,,
                for (int num : arr) {
                    System.out.print(num + " ");
                }
                System.out.println();
                // System.out.println(Arrays.toString(arr));
                reference = arr;
            }
        }
    }
}
