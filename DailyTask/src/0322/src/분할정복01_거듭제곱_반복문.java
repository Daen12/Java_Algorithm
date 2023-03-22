
public class 분할정복01_거듭제곱_반복문 {
	public static void main(String[] args) {
		int C = 2;
		int N = 10;
		System.out.println(powerLikeFac(C,N));
		System.out.println(pow(C,N));
		
	}
	
	//반복문으로 거듭제곱 구하기
	public static int pow(int C, int N) {
		for(int i=0; i<N; i++) {
			C = C*C;
		}
		return C;
	}
	
	//팩토리얼 처럼 재귀 돌려보자
	public static int powerLikeFac(int C, int N) {
		if(N==1) return C;
		return powerLikeFac(C, N-1)*C;
	}
}
