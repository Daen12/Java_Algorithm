import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q2798_bronze2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 21에서 3장의 합을 뺀 값이 가장 작은 3장의 합!
        // 순열..?
        int N = in.nextInt();
        int Near = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        List<Integer> sumList = new ArrayList<>();
        for (int i = 0; i <= N - 3; i++) {
            for (int j = i + 1; j <= N - 2; j++) {
                for (int k = j + 1; k <= N - 1; k++) {
                    sumList.add(Near - (arr[i] + arr[j] + arr[k]));
                }
            }
        }
        Collections.sort(sumList);
        // t가 답 인덱스!
        int t = 0;
        int val = sumList.get(t);
        while (val < 0) {
            t++;
            val = sumList.get(t);
        }
        System.out.println(Near - sumList.get(t));

    }
}
