import java.util.Scanner;

public class Q10972_다음순열_silver3 {
    static int[] nums;
    static int N;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }
        next_Permutation();

        System.out.println();
    }

    public static void next_Permutation(int idx) {
        // 한번 수행해도 됨!
        // 재귀 필요없음
        int A = 0;
        int B = 0;
        for (int i = 0; i < N - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                A = Math.max(A, i + 1);
            }
        }
        boolean Bfound = false;
        for(int i=1; i<N; i++){
            if(nums[A-1]<nums[i]){
                B = Math.max(B, i);
                Bfound = true;
            }
        }
        if(!Bfound) B = 1;
        //swap
        int temp = nums[A-1];
        nums[A-1] = nums[B];
        nums[B] = temp;

        //from A to N-1 flip the order
        
    }

}
