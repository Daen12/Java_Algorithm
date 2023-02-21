import java.util.Scanner;

class Q2292_벌집_bronze2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Num = in.nextInt();
        int to = 1;
        int t = 1;
        while (Num > to) { // 13
            to = to + (6 * t);
            t++;
        }
        System.out.println(t);
    }

}