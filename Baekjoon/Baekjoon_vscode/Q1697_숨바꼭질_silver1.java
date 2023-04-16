import java.util.Scanner;

public class Q1697_숨바꼭질_silver1 {
    static int subin, sis, seconds, ans;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        subin = in.nextInt();
        sis = in.nextInt();
        ans = 0;
        seconds = 0;
        DFS(subin, 0);

        System.out.println(ans);
    }

    public static void DFS(int subin, int seconds) {
        if (subin == sis) {
            ans = seconds;
            return;
        }
        if (subin <= 0 || subin > sis)
            return;

        seconds++;
        System.out.println(subin);
        DFS(subin - 1, seconds);
        System.out.println(subin);
        DFS(subin * 2, seconds);
        System.out.println(subin);
        // DFS(subin + 1, seconds);
    }
}
