import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1697_숨바꼭질_BFS_silver1 {
    static int subin, sis, seconds, ans;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        subin = in.nextInt();
        sis = in.nextInt();
        visited = new boolean[100001];
        System.out.println(BFS(subin));
    }

    public static int BFS(int subin) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { subin, 0 });

        while (!queue.isEmpty()) {
            int[] val = queue.poll();
            if (val[0] == sis)
                return val[1];

            if (valid(val[0] * 2) && !visited[val[0] * 2]) {
                queue.offer(new int[] { val[0] * 2, val[1] + 1 });
                visited[val[0]] = true;
            }
            if (valid(val[0] + 1) && !visited[val[0] + 1]) {
                queue.offer(new int[] { val[0] + 1, val[1] + 1 });
                visited[val[0] + 1] = true;
            }
            if (valid(val[0] - 1) && !visited[val[0] - 1]) {
                queue.offer(new int[] { val[0] - 1, val[1] + 1 });
                visited[val[0] - 1] = true;
            }
        }
        return 0;
    }

    public static boolean valid(int val) {
        return (val >= 0 && val <= 100000);
    }
}
