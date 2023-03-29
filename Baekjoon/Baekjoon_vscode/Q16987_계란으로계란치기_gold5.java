import java.util.Arrays;
import java.util.Scanner;

public class Q16987_계란으로계란치기_gold5 {
    // 조합문제. 가능한 조합 NC2중 몇개가 깨진 계란일 것인가?
    // 들고있는 계란 (=hold)이 깨지면 다음 홀드로
    // 대상 계란이 깨지면 다음 대상으로
    static int[] strengths, weights, order;
    static int cnt, N;
    static int[] hit;
    static boolean[] isUsed;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        strengths = new int[N];
        weights = new int[N];
        for (int i = 0; i < N; i++) {
            strengths[i] = in.nextInt();
            weights[i] = in.nextInt();
        }
        System.out.println(Arrays.toString(strengths));
        System.out.println(Arrays.toString(weights));
        cnt = 0;
        isUsed = new boolean[N];
        DFS(0, 1, 1, 1);
        System.out.println(cnt);
    }

    // public static void DFS(int depth, int o, int hold){
    //     o = N-hold;
    //     order = new int[o];
    //     if(depth == o){//치는 순서 정해지면
    //         for(int i=0; i<o; i++){
    //             order[i]
    //         }
    //     }

    //     //hold = 0 들고있는 계란의 인덱스
    //     strengths[hold] = strengths[hold] - weights[hit];// 들고있는 계란 내구도
    //     strengths[hit] = strengths[hit] - weights[hold]; // 대상계란 내구도

    //     for(int i=0; i<N; i++){
    //         if(!isUsed[i]){
    //             isUsed[i] = true;
    //             order[depth] = i;
    //             DFS(depth+1, o, hold);
    //             isUsed[i] = false;
    //         }
    //     }

    // }

    public static void DFS(int hold, int hit, int holdB, int hitB) {
        if (hold == N - 1)
            return;
        if (hit == N) {
            hold++;
            hit = hold + 1;
            return;
        }
        // 이미 깨져있었는지 확인용
        holdB = strengths[hold];// 1
        hitB = strengths[hit]; // 8

        strengths[hold] = strengths[hold] - weights[hit];// 들고있는 계란 내구도
        strengths[hit] = strengths[hit] - weights[hold]; // 대상계란 내구도

        if (strengths[hold] <= 0 && strengths[hit] <= 0) {// 둘다 깨졌으면
            if (holdB > 0)
                cnt++;
            if (hitB > 0)
                cnt++;
            hold++;
            hit = hold + 1;
        } else if (strengths[hit] <= 0) {// 대상계란만 깨졌으면
            if (hitB > 0)
                cnt++;
            hit++;
        } else if (strengths[hold] <= 0) {// 들고있는 계란만 깨졌으면
            if (holdB > 0)
                cnt++;
            hold++;
            hit = hold + 1;
        } else {// 아무것도 안 깨졌으면
            hit++;
        }
        DFS(hold, hit, holdB, hitB);
    }
}

// if (strengths[hold] - weights[hit] < strengths[hit] - weights[hold]) { // 만약
// 들고있는 계란이 깨지면
// hold++;
// hit = hold + 1;
// cnt++;
// } else if (strengths[hold] - weights[hit] > strengths[hit] - weights[hold]) {
// hit++;
// cnt++;
// }
