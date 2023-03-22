package solving_club;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q4012_�丮�� {

	static int[] select = new int[2];
	static int cnt = 0;
	static int[] ingNums;
	static int[] ingNums2;

	static List<int[]> list = new ArrayList<int[]>();
	static List<int[]> list2 = new ArrayList<int[]>();

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			int diff = Integer.MAX_VALUE;

			int N = in.nextInt();
			int[][] synergy = new int[N][N];
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					synergy[r][c] = in.nextInt();
				}
			}
			//��� ���� = �ε����� ����.
			//�κ�����..? //{"��ġ", "���", "����"};
			for(int i=0; i<(1<<N); i++) {//��� �κ������� ����� ��
				int[] ing = new int[N];
				int[] ing2 = new int[N];
				cnt = 0;
				for(int j=0; j<N; j++) {//�� ��ᰡ ������ Ȯ��
					if((i & (1<<j))>0) {
						//j��° ��Ḧ ���ٴ� ��!
						ing[j] = 1;
					}
					if(((1<<N)+(~i) & (1<<j))>0){
						ing2[j] = 1;
					}
				}
				System.out.println("ing1 : "+Arrays.toString(ing));
				System.out.println("ing2 : "+Arrays.toString(ing2));
				//���� ��� ���� Ȯ��
				for(int k=0; k<N; k++) {
					if(ing[k] == 1) {
						cnt++;
					}
				}
				if(cnt == N/2) { //���� ���� ����� ������ 2/N�϶���
					//�迭�� ����� �ε��� �ֱ�
					ingNums = new int[cnt];
					ingNums2 = new int[cnt];
					int idx = 0;
					int idx2 = 0;
					for(int k=0; k<N; k++) {
						if(ing[k] == 1) {
							ingNums[idx++] = k;
						}
						if(ing2[k] == 1) {
							ingNums2[idx2++] = k;
						}
					}
//					System.out.println("ingNums : "+Arrays.toString(ingNums));
//					System.out.println("ingNums2 : "+Arrays.toString(ingNums2));
					//�迭�� ���ڰ� �־������� , �� ���ڵ��� ������ ���ϱ�
					combination(0,0, list, ingNums); //����Ʈ�� ������ �迭�� ��� ����ֱ�
					combination(0,0, list2, ingNums2);
					int taste = 0;
					int taste2 = 0;
					for(int j=0; j<list.size(); j++) {
						taste += synergy[list.get(j)[0]][list.get(j)[1]];
						taste += synergy[list.get(j)[1]][list.get(j)[0]];
						taste2 += synergy[list2.get(j)[0]][list2.get(j)[1]];
						taste2 += synergy[list2.get(j)[1]][list2.get(j)[0]];
					}
//					System.out.println("taste1 : "+taste);
//					System.out.println("taste2 : "+taste2);
					diff = Math.abs(taste - taste2) < diff? Math.abs(taste-taste2) : diff;
					list.clear();
					list2.clear();
				}
			}
			System.out.printf("#%d %d\n", t, diff);
		}
	}
	
	public static void combination(int idx, int sIdx, List<int[]> list, int[] ingNums) {
		if(sIdx == 2) {
			list.add(select.clone());
			return;
		}
		if(idx == cnt) {
			return;
		}
		select[sIdx] = ingNums[idx];
		combination(idx+1, sIdx+1, list, ingNums);
		combination(idx+1, sIdx, list, ingNums);
	}
}
