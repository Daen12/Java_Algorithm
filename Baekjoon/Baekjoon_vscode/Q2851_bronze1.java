import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2851_bronze1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = 0;
        int after = 0;
        int prev = 0;
        int answer = 0;
        while (i < 10) {
            after += in.nextInt();
            if (after >= 100) {
                answer = after;
                break;
            }
            prev = after;
            i++;
        }
        if (100 - prev >= after - 100) {
            answer = after;
        } else if (100 - prev < after - 100) {
            answer = prev;
        }
        System.out.println(answer);
    }

}
