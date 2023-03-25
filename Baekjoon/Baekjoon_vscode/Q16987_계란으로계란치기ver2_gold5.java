import java.util.Scanner;
import java.util.Stack;

public class Q16987_계란으로계란치기ver2_gold5 {
    // 조합문제. 가능한 조합 NC2중 몇개가 깨진 계란일 것인가?
    // 들고있는 계란 (=hold)이 깨지면 다음 홀드로
    // 대상 계란이 깨지면 다음 대상으로
    static int[] strengths, weights;
    static int cnt, N;
    static int[] hit;
    static boolean[] cracked;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        strengths = new int[N];
        weights = new int[N];
        for (int i = 0; i < N; i++) {
            strengths[i] = in.nextInt();
            weights[i] = in.nextInt();
        }
        cracked = new boolean[N];
        DFS(0, 1);
        System.out.println(cnt);
    }

    public static void DFS(int depth, int idx) {
        if(depth == 2){
            int hit = stack.pop(); //0
            int hold = stack.pop(); //1

        }
        for(int i=idx; i<N; i++){
            stack.push(i);
            DFS(depth+1, i+1);
            stack.pop();
        }

    }

}
