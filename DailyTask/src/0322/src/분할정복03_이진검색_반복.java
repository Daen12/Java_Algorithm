import java.util.Arrays;

public class 분할정복03_이진검색_반복 {
	public static void main(String[] args) {
		int[] arr = { 28, 17, 6, 8, 9, 2, 4 };
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int key = 28;
		int result = -1;
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) / 2; // 계산은 괄호순서로~~
			if (arr[mid] == key) {
				result = mid;
				break;
			} else if (arr[mid] > key) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(result);
	}
}
