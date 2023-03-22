package solving_club;

import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Arrays;

public class Q14229_백만개의정수정렬_D2 {
	static int[] arr;
	static int[] sortedArr;
	
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		arr = new int[1000000];
		for(int i=0; i<1000000; i++) {
			arr[i] = in.nextInt();
		}
//		arr = new int[] {69, 10, 30, 2, 16, 8, 31, 22};
		sortedArr = new int[arr.length];
		mergeSort(0, arr.length-1);
		System.out.println(arr[500000]);
	}
	
	//�������ִ� ģ��
	public static void mergeSort(int left, int right) {
		if(left >= right) return;
		
		int mid = (left + right)/2;
		mergeSort(left, mid); //���� �ɰ���
		mergeSort(mid+1, right); //������ �ɰ���
		//������ ���� �� ���ҷ� �ɰ�����.(69, 10) ��׸� ������ ������ �ؾ� ��.
		//�ٽ� ���� ������ ���Ұ� �ΰ���!
		merge(left, mid, right);
	}

	private static void merge(int left, int mid, int right) {
		int L = left; //������Ʈ 0
		int R = mid+1; //��������Ʈ 1
		int idx = left; //0
		//�� �ΰ� ��, �� ���� ���� �Ҹ�
		while(L<=mid && R<=right) {
			if(arr[L] <= arr[R]) {
				sortedArr[idx++] = arr[L++]; //�� ����ģ���� �տ� ����
			} else {
				sortedArr[idx++] = arr[R++]; //�Ź�L/R�����Ͱ� �ٲ�.
			}
		} //while�� ������  L>mid Ȥ�� R>right
		//���� �ϳ��� ������ ����.
		if(L<=mid) {//���� ���� �κп� ���ڰ� �����ִٸ�
			for(int i=L; i<=mid; i++) {
				sortedArr[idx++] = arr[i];
			}
		} else {
			for(int j=R; j<=right; j++) {
				sortedArr[idx++] = arr[j];
			}
		}
		for(int i=left; i<=right; i++) {
			arr[i] = sortedArr[i];
		}
	}
}
