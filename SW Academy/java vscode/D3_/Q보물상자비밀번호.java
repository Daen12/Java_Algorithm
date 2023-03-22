import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Q�������ں�й�ȣ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		String[] hexa = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
		
		for(int t=1; t<=T; t++) {
			int N = in.nextInt(); //�� �
			int K = in.nextInt(); //���° ū ��
			String[] input = in.next().split("");
			LinkedList<String> list = new LinkedList<>();
			for(int i=0; i<N; i++) {
				list.add(input[i]); //���ڿ� ���·� �ֱ�
			}
			System.out.println(list);
			//�迭 ��������
			//��ȸ�� �������� ���
			int turn = N/3-1;
			int[] ints = new int[N/3 * turn];
			Set<Integer> set = new HashSet<>();
			int a = 0, b = 0, c = 0;
			int k = 0;
			for(int i=0; i<turn; i++) {
				for(int n=0; n<N-2; n+=3) {//3��
					for(int h=0; h<hexa.length; h++) {
						if(list.get(n).equals(hexa[h])) {
							a = h;
						}
						if(list.get(n+1).equals(hexa[h])) {
							b = h;
						}
						if(list.get(n+2).equals(hexa[h])) {
							c = h;
						}
					}
					set.add(hexadecimal(a,b,c));
				}
				list.addFirst(list.remove(N-1));
			}
			
			List<Integer> convertedList = new ArrayList<>(set);
			Collections.sort(convertedList, Collections.reverseOrder());
			System.out.printf("#%d %d\n", t, convertedList.get(K-1));
		}
	}
	
	public static int hexadecimal(int a, int b, int c) {
		return a*(16*16) + b*16 + c;
	}
}
