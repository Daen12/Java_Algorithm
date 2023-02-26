package solving_club;

import java.util.LinkedList;
import java.util.Scanner;

public class Q1230_암호문3_D3 {
	public static void main(String[] args) {
		// linkedlist 활용하기
		Scanner in = new Scanner(System.in);
		for (int t = 1; t <= 1; t++) {
			int N = in.nextInt();
			LinkedList<Integer> list = new LinkedList<>();
			//
			for (int i = 0; i < N; i++) {
				list.addLast(in.nextInt());
			}
			int orderL = in.nextInt();
			for (int i = 0; i < orderL; i++) {
				String order = in.next();
				if (order.equals("I")) {
					int idx = in.nextInt();
					int addNum1 = in.nextInt();
					for (int n = 0; n < addNum1; n++) {
						list.add(idx, in.nextInt());
						idx++;
					}
				}
				if (order.equals("D")) {
					int idx = in.nextInt();
					int addNum2 = in.nextInt();
					for (int n = 0; n < addNum2; n++) {
						list.remove(idx + 1);
					}
				}
				if (order.equals("A")) {
					int addNum3 = in.nextInt();
					for (int n = 0; n < addNum3; n++) {
						list.addLast(in.nextInt());
					}
				}
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			
		}
	}
}
