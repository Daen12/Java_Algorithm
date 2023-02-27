import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Q17413_단어뒤집기2_silver3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        // System.out.println(Arrays.toString(input));
        // <> 사이는 그대로 프린트, 그외는 받아서 거꾸로 출력
        int i = 0;
        String answer = "";
        // System.out.println(input.length);
        while (i < input.length) {// 5
            if (input[i] == '<') { // 태그 열리면
                StringBuilder sb = new StringBuilder();
                while (input[i] != '>') {
                    sb.append(input[i]);
                    i++;
                }
                sb.append(input[i++]); // 닫는태그 어펜드
                answer += sb.toString(); // 그대로 attach
            } else { // 태그가 아니면
                StringBuilder sb = new StringBuilder();
                while (i < input.length && input[i] != '<' && input[i] != ' ') { // 태그나 공백이 아닌동안에
                    sb.append(input[i]);
                    i++;
                }
                answer += sb.reverse().toString();
                if (i < input.length && input[i] == ' ') {// 일반문자열 뒤에가 공백이면
                    answer += " ";
                    i++;
                }
            }
        }
        System.out.println(answer);
        // i < input.length &&
        // int[] nonTagIndex = new int[input.length];
        // for (int i = 0; i < input.length; i++) {
        // String str = input[i];
        // for (int j = 0; j < str.length(); j++) {
        // if (str.charAt(j) == '<' && j != 0) {
        // // 태그가 아닌 단어의 인덱스 저장
        // nonTagIndex[k++] = i;
        // }
        // }
        // }
        // input = input.split("<");
        // System.out.println(Arrays.toString(input));
        // System.out.println(Arrays.toString(nonTagIndex));
    }
}
