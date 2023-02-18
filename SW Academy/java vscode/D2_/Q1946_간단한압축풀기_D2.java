import java.util.Scanner;

public class Q1946_간단한압축풀기_D2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();

            String answer = "";
            for (int n = 1; n <= N; n++) {
                String content = in.next();
                int count = in.nextInt();
                String mid = "";
                for (int i = 0; i < count; i++) {
                    mid += content;
                }
                answer = answer + mid;
            }
            System.out.print("#" + t);
            for (int i = 0; i < answer.length(); i++) {
                if (i % 10 == 0) // 줄바꿈을 먼저! (나중에 하면 두번째 문자가 다음줄로 잘림)
                    System.out.println();// i=9, 18, 27, ...
                System.out.print(answer.charAt(i));
            }
            System.out.println();
        }
    }
}
