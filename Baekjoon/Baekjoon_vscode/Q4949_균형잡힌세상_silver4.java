import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q4949_균형잡힌세상_silver4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 마지막에 점이 있어야함
        // 열리면 닫혀야 함
        // 개수와 종류가 맞아야 함
        while (true) {
            Stack<Character> Stack = new Stack<>();
            boolean ended = false;
            boolean unbalanced = false;
            char[] scan = br.readLine().toCharArray();
            if (scan[0] == '.' && scan.length == 1) {
                break;
            } else {
                outer: for (int i = 0; i < scan.length; i++) {
                    char c = scan[i];
                    switch (c) {
                        case '(':
                            Stack.push(c);
                            break;
                        case ')':
                            if (!Stack.isEmpty() && Stack.peek() == '(') {
                                Stack.pop();
                            }
                            break;
                        case '[':
                            Stack.push(c);
                            break;
                        case ']':
                            if (!Stack.isEmpty() && Stack.peek() == '[') {
                                Stack.pop();
                            }
                            break;
                    }
                    if (i == scan.length - 1) {
                        ended = c == '.' ? true : false;
                    }
                }
                if (ended && Stack.isEmpty()) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }
}
