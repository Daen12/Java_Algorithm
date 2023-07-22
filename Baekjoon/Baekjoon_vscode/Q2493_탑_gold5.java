import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2493_탑_gold5 {
    // 6,9,5,7,4
    // 왼쪽 <-으로 발사
    // 어느 탑에서 수신하는지
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner in = new Scanner(System.in);
        Stack<Integer> number = new Stack<>();
        Stack<Integer> index = new Stack<>();
        int N = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st2.nextToken());// 6
        number.push(n);// 1
        index.push(1);
        sb.append(0 + " ");

        for (int i = 2; i <= N; i++) {
            int val = Integer.parseInt(st2.nextToken());// 4
            while (!number.isEmpty()) {
                if (val < number.peek()) {
                    sb.append(index.peek() + " ");
                    break;
                }
                number.pop(); // 어차피 더 큰 탑이 오른쪽에 존재 = 왼쪽 작은탑은 pop해도 무방함.
                index.pop();
            }
            if (number.isEmpty()) {
                sb.append(0 + " ");
            }
            number.push(val);// 9 7 (여기서 꺼냄)
            index.push(i);// 2 4
        }
        System.out.println(sb.toString());
    }
}
