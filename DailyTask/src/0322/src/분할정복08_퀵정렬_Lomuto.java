import java.util.Arrays;

public class 분할정복08_퀵정렬_Lomuto {
	//partition 함수를 통해 pivot이 자신의 위치에 가게 된다.
	//이후  left~pivot-1까지 퀵정렬
	//pivot~right까지 퀵정렬
	static int[] arr;
	static int[] sortedArr;
	
	public static void main(String[] args) {
		arr = new int[] {69, 10, 30, 2, 16, 8, 31, 22};
		sortedArr = new int[arr.length];
		quickSort(0, arr.length-1);
		System.out.println(Arrays.toString(arr));
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
//		int last = 0;
		for(int j=left; j<right; j++) { //피벗 전까지! 돌면서
			if(arr[j]<=pivot) {//j는 맨 왼쪽에서 시작.
				i++; //i는 j가 피봇보다 크면 움직이지 않음. 
				//swap
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				 
				//i를 기준으로 왼쪽 구간은 피봇보다 작거나 같은 구간.
				//i를 기준으로 오른쪽 구간은 피봇보다 큰 구간.
				//i가 곧 경계, j는 포인터 역할! if기준에 맞는지 확인 후 조건 맞으면 스왑해줌.
			}
//			last = j;
		}
		//right가 마지막값(피벗)을 가리킴.
		//i+1의 값이 피봇보다 크므로, 두 값을 swap
		int temp = arr[i+1];
		arr[i+1] = arr[right];
		arr[right] = temp;
		return i+1; //요게 피벗+1
	}
}
