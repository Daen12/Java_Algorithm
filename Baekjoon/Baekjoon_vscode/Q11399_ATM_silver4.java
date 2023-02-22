import java.util.Arrays;
import java.util.Scanner;

public class Q11399_ATM_silver4 {
    public static void main(String[] args) {
        // sorting
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] arr = new int[T];
        for (int t = 0; t < T; t++) {
            arr[t] = in.nextInt();
        }
        Arrays.sort(arr); // 1,2,3,3,4 //1,3,6,9,13
        int sum = 0;
        for (int i = 0; i < T; i++) {
            int[] copy = Arrays.copyOfRange(arr, 0, i + 1);
            int added = Arrays.stream(copy).reduce(0, (a, b) -> (a + b));
            sum += added;
        }
        System.out.println(sum);

        // int prev = 0;
        // int sum2 = 0;
        // for(int i=0; i<T; i++){
        // sum+=prev + arr[i];
        // prev+=arr[i];
        // }
    }
}
