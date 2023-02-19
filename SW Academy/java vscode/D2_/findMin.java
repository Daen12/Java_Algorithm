import java.util.Arrays;

public class findMin {
    public static void main(String[] args) {
        int[] A = { 4, 7, 3, 9, 2 };
        // k번째로 큰수. 인덱스는 -1이니까 k전까지 정렬!
        for (int i = 0; i < 3; i++) {
            // 앞에서부터 정렬됨
            int minIdx = i;
            for (int j = i + 1; j < A.length; j++) {
                // 가장 작은 원소의 '인덱스부터' 찾기
                if (A[minIdx] > A[j])
                    minIdx = j;
            }
            // 다 찾은 후 해당 인덱스 원소만 swap
            int temp = A[i];
            A[i] = A[minIdx];
            A[minIdx] = temp;
        }
        System.out.println(A[2]);
        System.out.println(Arrays.toString(A));
    }
}
