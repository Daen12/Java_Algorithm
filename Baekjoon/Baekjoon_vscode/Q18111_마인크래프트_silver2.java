import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

//똑같은 높이에 대해 중복 하지않기

public class Q18111_마인크래프트_silver2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();
        int B = in.nextInt();
        Integer[] arr = new Integer[N * M];

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N * M; i++) {
            arr[i] = in.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        // 순서대로 정렬
        // 가장 낮은 블록 -> 높은 블록 순으로 높이 맞춰보기
        // 재고 떨어지면 break
        Arrays.sort(arr, Collections.reverseOrder());

        int minT = Integer.MAX_VALUE;
        int ansH = 0;
        // outer: for (int i : set) {
        outer: for (int i = min; i <= max; i++) {

            int height = i;// 목표높이에 대해 모두 탐색
            int t = 0;
            int left = B;// 재고는 B로 초기화

            // {0,0,1,1,2,3}
            for (int j = 0; j < N * M; j++) {

                if (arr[j] - height > 0) {// 땅의 높이가 목표 높이보다 크면
                    t += (2 * (arr[j] - height));
                    left += (arr[j] - height);

                } else if (arr[j] - height < 0) {// 땅의 높이 < 목표 높이 + 인벤토리에서 꺼내기
                    if (left > 0) {
                        t += (height - arr[j]);
                        left -= (height - arr[j]);
                    } else {
                        break outer; // 이번 높이에 대해서는 계산 불가! + 이후 높이에 대해 의미없음
                    }
                }
            }

            if (minT > t) {
                minT = t;
                ansH = height;
            } else if (minT == t) {
                ansH = ansH < height ? height : ansH;
            }

        }
        System.out.println(minT + " " + ansH);
    }
}
