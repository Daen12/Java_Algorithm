import java.util.Scanner;

public class Q2839_설탕배달_silver4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        // Greedy algorithm
        
        // int fives = N / 5;
        //3으로만 나눠지는 경우
        if(N%3==0){
            int threes = N / 3;
            int fives = N/5;
            if(N-(3*threes)%5==0){
                int fives = N-(3*threes)/5;
            }
        }
        //5로만 나눠지는 경우

        //3 & 5로 나눠지는 경우

        //둘다 안나눠지는 경우
        int remainder = N - (5 * fives);
        if(remainder %3 == 0){

        int threes2 = remainder / 3;
        // int left = remainder - (3 * threes2);
        if (threes == 0 && fives == 0) {
            System.out.println(-1);
        } else
            System.out.println(Math.min(threes, fives + threes2));

    }
}
