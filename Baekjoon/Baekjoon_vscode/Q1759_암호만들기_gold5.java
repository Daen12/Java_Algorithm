import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q1759_암호만들기_gold5 {
    // 조합문제
    // 종료조건1. 최소 한개의 모음과 두개의 자음이 들어있음
    // 종료조건2. 증가하는 순서로 배열되어있음 - 요거는 sort로?
    // char로 받기

    static int N, M;
    static char[] moeums = new char[] { 'a', 'e', 'i', 'o', 'u' };
    static char[] chars;
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        M = in.nextInt(); // 4
        N = in.nextInt(); // 6
        chars = new char[N];
        for (int i = 0; i < N; i++) {
            chars[i] = in.next().charAt(0);
        }
        Arrays.sort(chars);
        DFS(0, 0);
        System.out.println(sb);

    }

    public static void DFS(int depth, int idx) {
        if (depth == M) {
            int jaeum = 0;
            int moeum = 0;
            for (char c : stack) {
                for (int i = 0; i < moeums.length; i++) {// 만들어진 조합에 몇개의 모음있는지 검사
                    if (c == moeums[i])
                        moeum++;
                }
            }
            jaeum = M - moeum;
            if (moeum >= 1 && jaeum >= 2) {// 최소조건
                for (char c : stack) {
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = idx; i < N; i++) {
            stack.push(chars[i]);
            DFS(depth + 1, i + 1);
            stack.pop();
        }
    }
}
