import java.util.Arrays;

public class 분할정복07_퀵정렬_Hoare {
	// partition 함수를 통해 pivot이 자신의 위치에 가게 된다.
	// 이후 left~pivot-1까지 퀵정렬
	static int[] arr;

	public static void main(String[] args) {
		arr = new int[] { 69, 10, 30, 2, 16, 8, 31, 22 };
		quickSort(0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = HoarePartition(left, right);
			quickSort(left, pivot - 1);// 피벗을 뺀 범위
			quickSort(pivot + 1, right);
		}
	}

	public static int HoarePartition(int left, int right) {
		// 맨 왼쪽을 기준으로 피벗 위치 옮겨주기
		int pivot = arr[left];
		int L = left + 1; // 피봇이 맨 앞에 있으니까 그 후가 가장 왼쪽
		int R = right;
		while (L <= R) {
			while (L <= R && arr[L] <= pivot) { // 안에서 L<=R조건 또 써주는 이유 : while문은 안에서 조건을 보고 도니까 바깥조건은 소용 없음
				L++; // pivot보다 큰 값을 만나면 멈춤 //슬라이드에서 3
			}
			while (arr[R] > pivot) {
				R--;// pivot보다 작은 값을 만나면 멈춤. //예시 슬라이드에서 2
			}
			if (L < R) {
				int temp = arr[L];
				arr[L] = arr[R];
				arr[R] = temp;
			}
		} // L>R일때 while문 빠져나옴
			// swap
		int temp = arr[left]; // left는 피벗이 있던 자리.
		arr[left] = arr[R]; // R는 피벗이 있어야할 곳(피벗보다 작은값들의 가장 오른쪽 인덱스)
		arr[R] = temp;

		return R;

	}
}
