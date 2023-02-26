package solving_club;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1225_암호생성기_D3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int T = in.nextInt();
			// 큐에 8개 값 넣기
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				queue.offer(in.nextInt());
			}

			outer : while (true) {
				// cycle
				for (int i = 1; i <= 5; i++) {
					if (queue.peek() - i <= 0) {
						queue.poll();
						queue.offer(0);
						break outer;
					} else {
						queue.offer(queue.poll() - i);
					}
				}
			}
			//큐에서 하나씩 빼서 값 출력
			System.out.print("#"+T+" ");
			for(int i=0; i<8; i++) {
				System.out.print(queue.poll() + " ");
			}
		}

	}
}
