
import java.util.Arrays;
import java.util.Scanner;

public class Q2007_D2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = Integer.parseInt(in.nextLine());

        // length를 늘려가며 char 값 하나씩 비교, 다 맞으면 해당 length 출력하기
        for (int t = 1; t <= T; t++) {
            String str = in.nextLine();
            char[] charArr = str.toCharArray();
            System.out.println(Arrays.toString(charArr));
            int length = 1;
            outer: while (true) {
                int count = 0;
                for (int i = 0; i < length; i++) {
                    if (charArr[i] != charArr[i + length]) {
                        length++;
                        break;
                    }
                    count++;
                }
                if (count == length)
                    break;
            }
            System.out.printf("#%d %d\n", t, length);
        }
    }
}
