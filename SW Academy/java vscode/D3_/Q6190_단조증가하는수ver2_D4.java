package solving_club;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q6190_단조증가하는수ver2_D4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine()); // 4
			int[] nums = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			// 순열!
			// 두 수 곱해서 -> 최댓값 비교 후 -> 만약 오름차순이면 업데이트
			int max = -1;
			
			for (int i = 0; i < N - 1; i++) { // 뒤에서부터
				for (int j = i + 1; j < N; j++) {
					System.out.println(i + " " + j);
					int target = nums[i] * nums[j]; // 28
					String str = String.valueOf(target); // "28"

					if (str.length() == 1) { // 길이가 1이면 답
						if (max < target) {
							max = target;
						}
					} else {
						boolean flag = true;
						for (int k = 0; k < str.length() - 1; k++) { // k를 문자열 끝까지 돌면서
							if (str.charAt(k) > str.charAt(k + 1)) {
								flag = false;
								break; //다른 곱셈 조합보기!
							}
						}
						if(flag == true && max<target) {
							max = target;
						}
					}
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}
}
