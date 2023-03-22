import java.util.Arrays;

public class 분할정복06_병합정렬 {
	static int[] arr;
	static int[] sortedArr;
	
	public static void main(String[] args) {
		arr = new int[] {69, 10, 30, 2, 16, 8, 31, 22};
		sortedArr = new int[arr.length];
		mergeSort(0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	//분할해주는 친구
	public static void mergeSort(int left, int right) {
		if(left >= right) return;
		
		int mid = (left + right)/2;
		mergeSort(left, mid); //왼쪽 쪼개기
		mergeSort(mid+1, right); //오른쪽 쪼개기
		//요기까지 오면 한 원소로 쪼개진것.(69, 10) 얘네를 가지고 병합을 해야 함.
		//다시 병합 만나면 원소가 두개씩!
		merge(left, mid, right);
	}

	private static void merge(int left, int mid, int right) {
		int L = left; //왼쪽파트 0
		int R = mid+1; //오른쪽파트 1
		int idx = left; //0
		//값 두개 비교, 더 작은 값을 소모
		while(L<=mid && R<=right) {
			if(arr[L] <= arr[R]) {
				sortedArr[idx++] = arr[L++]; //더 작은친구가 앞에 오게
			} else {
				sortedArr[idx++] = arr[R++]; //매번L/R포인터가 바뀜.
			}
		} //while문 끝나면  L>mid 혹은 R>right
		//둘중 하나가 끝까지 간것.
		if(L<=mid) {//아직 왼쪽 부분에 숫자가 남아있다면
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
