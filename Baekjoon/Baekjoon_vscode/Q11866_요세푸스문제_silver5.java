package solving_club;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q11866_요세푸스문제_silver5 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		int i = 1;
		while (i <= N) {
			queue.add(i++);
		} // 1-N까지 쌓임.
		int count = 0;
		System.out.print("<");
		while (queue.size() != 1) {
			count++;
			if (count == K) {
				System.out.print(queue.poll() + ", ");
				count = 0;
			} else {
				
				queue.offer(queue.poll());
			}
		}
		System.out.print(queue.poll() + ">");

	}

}
