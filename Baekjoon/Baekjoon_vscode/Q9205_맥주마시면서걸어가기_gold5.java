import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q9205_맥주마시면서걸어가기_gold5 {
    static String ans;
    static int storeNum;
    static ArrayList<Integer>[] graph;

    public static class Grid {
        int x;
        int y;

        public Grid(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        // 맥주 20개
        // 50미터에 한병
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            ans = "";
            storeNum = in.nextInt();
            Grid[] grids = new Grid[storeNum + 2]; // input을 담는 용도

            for (int i = 0; i < storeNum + 2; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                grids[i] = new Grid(x, y);
            }
            graph = new ArrayList[storeNum + 2];
            for (int i = 0; i < storeNum + 2; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < storeNum + 2; i++) {
                for (int j = i + 1; j < storeNum + 2; j++) {
                    if (dist(grids[i], grids[j]) <= 1000) {
                        graph[i].add(j);
                        graph[j].add(i);
                    }
                }
            }
            BFS();

            System.out.println(ans);
        }
    }

    public static int dist(Grid g1, Grid g2) {
        return (Math.abs(g1.x - g2.x)) + (Math.abs(g1.y - g2.y));
    }

    public static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[storeNum + 2];
        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int pa = queue.poll();
            for (int child : graph[pa]) {
                if (!visited[child]) {
                    queue.offer(child);
                    visited[child] = true;
                }
            }
        }
        if (visited[storeNum + 1] == true) {
            ans = "happy";
        } else {
            ans = "sad";
        }
    }
}
