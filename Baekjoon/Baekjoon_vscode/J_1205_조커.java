import java.util.Arrays;
import java.util.Scanner;

public class J_1205_조커 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] cards = new int[N];
        int Joker = 0;
        for (int n = 0; n < N; n++) {
            cards[n] = in.nextInt();
            if (cards[n] == 0)
                Joker++;
        }
        Arrays.sort(cards);
        int max = 0;
        int count = 1;
        int useJoker = Joker;
        for (int i = Joker; i < N - 1; i++) {
            int diff = cards[i + 1] - cards[i];
            if (diff == 1) {
                count++;
            } else {
                if (diff - 1 <= Joker) {
                    Joker -= (diff - 1);
                    count++;
                } else {
                    // 카운트의 max갱신
                    if (count > max) {
                        max = count;
                    }
                    count = 0;
                    useJoker = Joker;
                }
            }
        }
        System.out.println(max);

    }
}
