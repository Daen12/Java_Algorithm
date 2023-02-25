
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q14696_딱지놀이_bronze1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st1.nextToken());
			int[] A = new int[a];
			for (int i = 0; i < a; i++) {
				A[i] = Integer.parseInt(st1.nextToken());
			}
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st2.nextToken());
			int[] B = new int[b];
			for (int i = 0; i < b; i++) {
				B[i] = Integer.parseInt(st2.nextToken());
			}
			// 더 긴 배열만큼 늘리기
			if (a > b) {
				int[] copy = new int[a];
				for (int i = 0; i < b; i++) {
					copy[i] = B[i];
				}
				B = copy;
			} else {
				int[] copy = new int[b];
				for (int i = 0; i < a; i++) {
					copy[i] = A[i];
				}
				A = copy;
			}

			Integer[] newA = Arrays.stream(A).boxed().toArray(Integer[]::new);
			Integer[] newB = Arrays.stream(B).boxed().toArray(Integer[]::new);
			// 여기까지 입력!
			// 거꾸로 sorting
			Arrays.sort(newA, Collections.reverseOrder());
			Arrays.sort(newB, Collections.reverseOrder());
			String winner = "";
			// 루프 돌면서 숫자 비교. 숫자가 더 크면 A, 작으면 B/break
			for (int i = 0; i < newA.length; i++) {
				if (newA[i] > newB[i]) {
					winner = "A";
					break;
				} else if (newA[i] < newB[i]) {
					winner = "B";
					break;
				} else if (i == newA.length - 1 && newA[i] == newB[i]) {
					winner = "D";
				}
			}
			// 끝까지 같으면 D
			System.out.println(winner);

		}
	}
}
