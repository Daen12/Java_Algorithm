import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q2493_탑_gold5_ver2 {
    // 왼쪽 <-으로 발사
    // 어느 탑에서 수신하는지
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        int[] ans = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st2.nextToken());
        }
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                sb.append(0 + " ");
                continue;
            }
            int t = i - 1;
            boolean findTop = true;
            while (nums[t] < nums[i]) {
                if (t == 0) {
                    findTop = false;
                    break;
                }
                t--;
            }
            if (findTop) {
                sb.append(t + 1 + " ");
            } else {
                sb.append(0 + " ");
            }
        }
        System.out.println(sb.toString());
    }
}