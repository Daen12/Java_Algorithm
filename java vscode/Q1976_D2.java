import java.util.Scanner;

public class Q1976 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int hour1 = in.nextInt();
            int minute1 = in.nextInt();
            int hour2 = in.nextInt();
            int minute2 = in.nextInt();

            int hour = hour1 + hour2;
            int minute = minute1 + minute2;
            // 분 먼저
            // 만약 60을 넘어간다면, 시에 1 더하고 분 - 60 하기
            if (minute >= 60) {
                minute -= 60;
                hour += 1;
            }
            // 만약 분이 12시 넘어간다면 시에서 -12하기
            if (hour >= 12) {
                hour -= 12;
            }

            System.out.println("#" + (t + 1) + " " + hour + " " + minute);
        }
    }
}
