

public class MyCombination {

    public static int[] arr;
    public static int n, r, count;
    public static boolean[] visited;

    public static void backTracking(int depth, int index) {
        if (depth == r) {
            count++;
            print();
            return;
        }

        for (int i = index; i < n; i++) {
            visited[i] = true;
            backTracking(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    static void print() {
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        // nCr 援ы븯湲�
        n = 6;
        r = 3;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        visited = new boolean[n];
        count = 0;

        backTracking(0, 0);
        System.out.printf("%dC%d = %d\n", n, r, count);
    }
}
