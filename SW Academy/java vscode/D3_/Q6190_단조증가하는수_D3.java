package solving_club;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q6190_단조증가하는수_D3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			int N = in.nextInt(); //4
			int[] nums = new int[N];
			for(int i=0; i<N; i++){
				nums[i] = in.nextInt();
			}
			//순열!
			//두 수 곱해서 -> 최댓값 비교 후 -> 만약 오름차순이면 업데이트 
			int max = 0;
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					int target = nums[i]*nums[j]; //28
					if(max<target) {
						String[] str = String.valueOf(target).split("");//["2","8"]
						int[] parsed = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
						int[] copy = Arrays.copyOf(parsed,parsed.length);
						Arrays.sort(copy);
						if(Arrays.toString(copy).equals(Arrays.toString(parsed))) {
							max = target;
						}
					}
				}
			}
			System.out.printf("#%d %d\n",t,max);
			
		}
	}
}
