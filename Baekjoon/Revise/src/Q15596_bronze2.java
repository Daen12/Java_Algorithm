//함수만 만들기

class Test{
	
	long sum(int[] a) { //sum 함수가 리턴할 값의 타입 지정 =long
		long sum = 0;
		for(int i=0; i<a.length; i++) {
			sum+= a[i];
		}
		return sum;
		
	}
	
}

