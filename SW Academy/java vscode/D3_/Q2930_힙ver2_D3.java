package solving_club;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Q2930_힙ver2_D3 {
	static int[] heap; // N+1의 크기, 그러나 다 쓰는거 아님. 이걸 알기위해서
	static int lastIdx; // 마지막 원소의 인덱스를 저장하기

	public static void main(String[] args) {
		// 테케
		// 연산수
		// 연산
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			System.out.print("#" + t);
			Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
			
			int N = in.nextInt();
			heap = new int[N + 1]; // 최대 N번 삽입될 수 있으므로!
			lastIdx = 0; // 인덱스 더한 후 추가할것임.

			for (int n = 1; n <= N; n++) {
				int cal = in.nextInt();
				if (cal == 1) { // 삽입
					// 가장 마지막 배열에 추가해서 루트로 거슬러올라감.
					int add = in.nextInt();
					queue.add(add);
					
				} else { // 삭제
					if (queue.size() == 0) {
						System.out.printf(" " + -1);
					} else {
						System.out.printf(" " + queue.poll()); // 출력 후
					}
					// 마지막 원소를 루트노드로
				}
			}
			System.out.println();
		}
	}

	// 배열의 교환연산은 swap이라는 메서드로 따로 처리하자.
	public static void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;

	}
}
