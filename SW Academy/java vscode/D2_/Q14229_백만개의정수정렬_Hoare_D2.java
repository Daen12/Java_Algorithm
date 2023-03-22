package solving_club;

import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Arrays;

public class Q14229_백만개의정수정렬_Hoare_D2 {
	static int[] arr;
	static int[] sortedArr;
	
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		arr = new int[1000000];
		for(int i=0; i<1000000; i++) {
			arr[i] = in.nextInt();
		}
		sortedArr = new int[arr.length];
		quickSort(0, arr.length-1);
		System.out.println(arr[500000]);
	}
	
	public static void quickSort(int left, int right) {
		if(left < right) {
			int pivot = HoarePartition(left, right);
			quickSort(left, pivot-1);
			quickSort(pivot+1, right);
		}
	}
	
	public static int HoarePartition(int left, int right) {
		//�� ������ �������� �ǹ� ��ġ �Ű��ֱ�
		int pivot = arr[left];
		int L = left+1; //�Ǻ��� �� �տ� �����ϱ� �� �İ� ���� ����
		int R = right;
		while(L<=R) {
			while(L<=R && arr[L] <=pivot) { //�ȿ��� L<=R���� �� ���ִ� ���� : while���� �ȿ��� ������ ���� ���ϱ� �ٱ������� �ҿ� ����
				L++; //pivot���� ū ���� ������ ����
			}
			while(arr[R] > pivot) {
				R--;//pivot���� ���� ���� ������ ����.
			}
			if(L < R) {
				int temp = arr[L];
				arr[L] = arr[R];
				arr[R] = temp;
			}
		}
		//swap
		int temp = arr[left];
		arr[left] = arr[R];
		arr[R] = temp;
		
		return R;
		
	}
}
