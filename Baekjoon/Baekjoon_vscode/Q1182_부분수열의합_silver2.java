package solving_club;

import java.util.Scanner;

public class Q1182_�κм�������_silver2 {
	static int[] nums;
	static int S;
	static int N;
	static int count;
	static int cnt;
	//������ ���ؼ� ���ϴ� ����.
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		S = in.nextInt();
		nums = new int[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = in.nextInt();
		}
		count = 0;//�� ���ɸ��� ���� 0���� �ʱ�ȭ
		cnt = 0;
		combination(0, 0);
		System.out.println(count);
	}
	static void combination(int idx, int sum) {
		
//		System.out.println(cnt);
		if(idx == N) {//�ε��� 3���� �� �� +1�ؼ� 4�� ȣ��Ǿ��ٸ�
			cnt++;
			if(sum == S && cnt!=Math.pow(2, N)) {//���� S�� ���ٸ� & �������� �ƴ� ���
				count++;
			}
			//���� S�� ���� ������ if���� �Ȱɸ�. --> �׳� ����
			return; //���ư�
		}
		combination(idx+1,sum+nums[idx]); //���ϴ� ���
		combination(idx+1, sum); //�ȴ��ϴ� ���
	}
//	
}
