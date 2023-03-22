import java.util.Arrays;

public class 분할정복04_이진검색_재귀 {
	static int[] arr;
	static int key;
	public static void main(String[] args) {
		arr = new int[]{ 28, 17, 6, 8, 9, 2, 4 };
		Arrays.sort(arr); //정렬되어있어야 함.
		key = 17;
		
		System.out.println(binarySearch(0, arr.length-1));
	}
	
	//이진검색 - 안에 들었나?(boolean) OR 어디에 들었나?(int)
	public static boolean binarySearch(int start, int end) {
		//기저조건 : 못찾았다
		if(start > end) return false;
		
		int mid = (start + end) /2;
		
		if(arr[mid] == key) {
			return true;
		}else if(arr[mid] > key) {
			return binarySearch(start, mid-1); //리턴을 꼭 해야함.  
		}else{
			return binarySearch(mid+1, end); //리턴 안하면 불리언값이 그냥 반환되고 아무런 저장도 되지 않아서, 맨밑에있던  false가 무조건 반환됨.
		}
		//위에서 리턴을 다 했기 때문에 죽은 코드!
		//return false;
	}
}
