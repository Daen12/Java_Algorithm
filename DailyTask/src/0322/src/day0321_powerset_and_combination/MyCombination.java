
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
            backTracking(depth + 1, i + 1); // true인 상태에서 넣고, 뽑을때 visited인지 본다
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
        // nCr 구하기
        n = 6;
        r = 3;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        } // {1,2,3,4,5,6}
        visited = new boolean[n];
        count = 0;

        backTracking(0, 0);
        System.out.printf("%dC%d = %d\n", n, r, count);
    }
}
