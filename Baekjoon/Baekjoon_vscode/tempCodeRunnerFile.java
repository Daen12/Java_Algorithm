import java.util.Arrays;
import java.util.Scanner;

public class Q2941_크로아티아알파벳_silver5 {
    public static void main(String[] args) {
        String[] croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

        Scanner in = new Scanner(System.in);
        String input = in.next();
        int three = 0;
        int total = 0;
        // 문자열에서 각 알파벳 개수를 구하기
        for (int i = 0; i < croatia.length; i++) {
            String replaced = input.replace(croatia[i], "1");
            int count = (int) replaced.chars().filter(c -> c == '1').count();
            // 만약 세번째 문자열 포함되어있으면 따로계산
            if (i == 2) {
                three += count;
            } else { // 나머지 문자열은 누적시키기
                total += count;
            }
        }
        // 나머지 알파벳 개수 = 전체문자열 - 크로아티아 개수
        int stringCount = (int) input.chars().count();
        int general = stringCount - (three * 3 + total * 2);
        System.out.println(general + three + total);

    }
}
