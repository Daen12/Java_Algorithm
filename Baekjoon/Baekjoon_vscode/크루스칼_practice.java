import java.util.Scanner;
import java.util.*;

public class 크루스칼_practice {
    static int[] parent;
    static Node[] nodes;

    // baekjoon 1197
    static class Node {
        int x, y, val;

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int V = in.nextInt(); // 정점의 개수(1-3)
        int E = in.nextInt(); // 간선의 개수

        parent = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            parent[i] = i;
        }
        // 간선의 정보 저장 후 작은 순서대로 정렬
        nodes = new Node[E];
        for (int i = 0; i < E; i++) {
            nodes[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
        }
        Arrays.sort(nodes, (Node n1, Node n2) -> {
            return n1.val - n2.val;
        });
        int min = 0;
        int pick = 0;
        for (int i = 0; i < E; i++) {
            int x = nodes[i].x;
            int y = nodes[i].y;
            if (findSet(x) != findSet(y)) {
                union(x, y);
                min += nodes[i].val;
            }
        }
        System.out.println(min);
    }

    public static int findSet(int x) {
        if (parent[x] != x) {
            parent[x] = findSet(parent[x]);
        }
        return parent[x];
    }

    public static void union(int x, int y) {
        parent[findSet(y)] = findSet(x);
    }
 
}
