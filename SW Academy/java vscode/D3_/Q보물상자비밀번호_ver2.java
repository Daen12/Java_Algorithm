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

public class Q�������ں�й�ȣ_ver2 {
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
			//�迭 ��������
			int turn = 3;
			int k = N/4; //�Ѻ��� ��� ����? //3
			Set<Integer> set = new HashSet<>();
			int[] ints = new int[12];
			int c = 0;
			for(int i=0; i<N/4; i++) {//������ �Ͽ� ���Ͽ�
				for(int n=0; n<N-(N/4-1); n+=N/4) {//÷���� ������, N/4�� �ڸ���
					int cal = 0;
					for(int h=0; h<hexa.length; h++) {
						int count=0;
						while(count<N/4) {
							if(list.get(n+count).equals(hexa[h])) {
								cal+=h*Math.pow(16, N/4-count-1);
							}
							count++;
						}
					}
					set.add(cal);
				}
				list.addFirst(list.remove(N-1));//turn
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

//if(list.get(n).equals(hexa[h])) {
//a = h;
//}
//if(list.get(n+1).equals(hexa[h])) {
//b = h;
//}
//if(list.get(n+2).equals(hexa[h])) {
//c = h;
//}
