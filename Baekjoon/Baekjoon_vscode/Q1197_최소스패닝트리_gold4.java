import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q1197_최소스패닝트리_gold4 {
    static int[] parent;
    static Node[] nodes;

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
        int V = in.nextInt();
        int E = in.nextInt();
        parent = new int[V + 1];
        // make set
        for (int i = 0; i < V + 1; i++) {
            parent[i] = i;
        }
        // kruskal
        nodes = new Node[E];
        for (int i = 0; i < E; i++) {
            nodes[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
        }
        // sort
        Arrays.sort(nodes, (Node n1, Node n2) -> {
            return n1.val - n2.val;
        });

        int minWeight = 0;
        int pick = 0;
        for (int i = 0; i < E; i++) {
            int x = nodes[i].x;
            int y = nodes[i].y;
            if (findSet(x) != findSet(y)) {
                union(x, y);
                minWeight += nodes[i].val;
                pick++;
            }
            if (pick == V - 1)
                break;
        }
        System.out.println(minWeight);
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
