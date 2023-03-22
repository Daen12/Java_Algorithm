
public class 분할정복02_거듭제곱_재귀 {
	public static void main(String[] args) {
		int C = 2;
		int N = 10;
		
		System.out.println(pow(C,N));
		
	}
	public static int pow(int C, int N) {
		
		if(N ==1)return C;
		
		//1. 짝수일떄, 2.홀수일때
		if(N%2 == 0) {
			return pow(C, N/2)*pow(C, N/2);
		} else {
			return pow(C, (N-1)/2)*pow(C, (N-1)/2)*C;
		}
	}
}
