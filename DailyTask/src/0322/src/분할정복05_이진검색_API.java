import java.util.Arrays;

public class 분할정복05_이진검색_API {
	static int[] arr;
	static int key;

	public static void main(String[] args) {
		arr = new int[] { 28, 17, 6, 8, 9, 2, 4 };
		Arrays.sort(arr); // 정렬해주어야함.
		key = 28;
		System.out.println(Arrays.binarySearch(arr, key));
	}
}
