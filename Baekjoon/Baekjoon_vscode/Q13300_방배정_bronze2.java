import java.util.Scanner;

public class Q13300_방배정_bronze2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        double K = in.nextInt();
        double[] girls = new double[6];
        double[] boys = new double[6];

        for (int t = 0; t < T; t++) {
            int gender = in.nextInt();
            int grade = in.nextInt();
            if (gender == 1)
                boys[grade - 1]++;
            else
                girls[grade - 1]++;
        }

        double rooms = 0;
        for (int i = 0; i < 6; i++) { // 학년마다
            rooms += Math.ceil(girls[i] / K);
            rooms += Math.ceil(boys[i] / K);
        }
        System.out.println((int) rooms);
    }
}
