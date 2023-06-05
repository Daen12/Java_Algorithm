import java.util.Scanner;

public class Q13458_시험감독_bronze2 {
    // 총감독관은 B, 부감독관은 C명 감시가능
    // 모두 감시해야
    // 감독관 수의 최솟값

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] students = new int[N];
        for (int i = 0; i < N; i++) {
            students[i] = in.nextInt();
        }

        int B = in.nextInt();
        int C = in.nextInt();

        Long supervisorPerClass = (long) 0;
        for (int i = 0; i < N; i++) {
            // 총감독관은 한명만 있어야 한다.
            supervisorPerClass++;
            students[i] -= B;
            if (students[i] > 0) {
                if (students[i] % C == 0) { // 만약 나누어 떨어지면
                    supervisorPerClass += (students[i] / C);
                } else {
                    supervisorPerClass += (students[i] / C + 1);
                }
            }
        }

        System.out.println(supervisorPerClass);
    }
}
