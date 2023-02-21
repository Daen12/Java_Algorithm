import java.util.Arrays;
import java.util.Scanner;

public class Q2309_일곱난쟁이_bronze1 {
    public static void main(String[] args) {
        // 9개 중 2개를 빼면 100이 되어야.
        // =2개를 합했을때 sum-100이 되어야한다
        Scanner in = new Scanner(System.in);
        int[] heights = new int[9];
        for (int i = 0; i < 9; i++) {
            heights[i] = in.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += heights[i];
        }
        int N = sum - 100;
        // 배열의 두 숫자를 합쳤을때 N이 되는 인덱스 두개 구하기
        int A = 0;
        int B = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (heights[i] + heights[j] == N) {
                    A = i;
                    B = j;
                    break;
                }
            }
        }
        // A와 B를 뺀 인덱스 '오름차순으로' 출력하기
        int[] finalHeights = new int[7];
        for (int i = 0, j = 0; i < 9; i++) {
            if (i != A && i != B)
                finalHeights[j++] = heights[i];
        }
        Arrays.sort(finalHeights);
        for (int height : finalHeights) {
            System.out.println(height);
        }
    }
}
