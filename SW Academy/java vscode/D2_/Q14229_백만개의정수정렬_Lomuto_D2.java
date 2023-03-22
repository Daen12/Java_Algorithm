package solving_club;

import java.util.Scanner;

public class Q14229_백만개의정수정렬_Lomuto_D2 {
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
			int pivot = LomutoPartition(left, right);
			quickSort(left, pivot-1);
			quickSort(pivot+1, right);
		}
	}
	
	public static int LomutoPartition(int left, int right) {
		int pivot = arr[right];
		int i = left-1;
		int last = 0;
		for(int j=left; j<right; j++) { //�ǹ� ������ ���鼭
			if(arr[j]<=pivot) {
				i++;
				//swap
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				 
				//i�� �������� ���� ������ �Ǻ����� �۰ų� ���� ����.
				//i�� �������� ������ ������ �Ǻ����� ū ����.
				//i�� �� ���, j�� ������ ����! if���ؿ� �´��� Ȯ�� �� ���� ������ ��������.
			}
			last = j;
		}
		//for���� ������ j�� ��������(�ǹ�)�� ����Ŵ.
		//i+1�� ���� �Ǻ����� ũ�Ƿ�, �� ���� swap
		int temp = arr[i+1];
		arr[i+1] = arr[right];
		arr[right] = temp;
		return i+1; //��� �ǹ�+1
	}
}
