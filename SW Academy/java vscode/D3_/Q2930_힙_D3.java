package solving_club;

import java.util.Scanner;

public class Q2930_힙_D3 {
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

			int N = in.nextInt();
			heap = new int[N + 1]; // 최대 N번 삽입될 수 있으므로!
			lastIdx = 0; // 인덱스 더한 후 추가할것임.

			for (int n = 1; n <= N; n++) {
				int cal = in.nextInt();
				if (cal == 1) { // 삽입
					// 가장 마지막 배열에 추가해서 루트로 거슬러올라감.
					int add = in.nextInt();
					heap[++lastIdx] = add;
					int cur = lastIdx; // 현재 노드는 마지막 노드에서 출발. 부모와 비교
					while (cur > 1 && heap[cur] > heap[cur / 2]) {// 자식이 부모보다 크면서 루트가 아니면
						// swap
						swap(cur, cur / 2);
						cur = cur / 2;
					}
				} else { // 삭제
					if (heap[1] == 0) {
						System.out.printf(" " + -1);
					} else {
						System.out.printf(" " + heap[1]); // 출력 후
					}
					// 마지막 원소를 루트노드로
					heap[1] = heap[lastIdx];
					heap[lastIdx--] = 0;
					// 루트노드에서 시작해서 거슬러내려감
					int cur = 1;
					while (true) {// leaf노드에 도달하거나 자식보다 크거나 같으면 중단.
						// 더 큰 자식으로 지정
						 int child = heap[cur*2] > heap[cur*2+1]? cur*2 : cur*2+1;
//						int child = cur * 2;
//						if (child + 1 <= lastIdx && heap[child] < heap[child + 1]) {// 오른쪽 자식 존재 & 더 크다면
//							child++; // 오른쪽 자식 선택
//						}
						// 부모와 비교 (부모가 자식보다 크면종료, 리프노드에 가면 종료)
						if (child > lastIdx || heap[child] < heap[cur])
							break;
						swap(cur, child);
						cur = child;
					}
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
