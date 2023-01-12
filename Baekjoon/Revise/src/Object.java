class Calculator{
	int left, right; //메소드 밖에서 선언한 변수 - 클래스 안의 모든 메서드에서 접근 가능해진다.
	
	public void setOperands(int left, int right) {
		this.left = left; //원래 left와 right는 매개변수로 setOperands 안에서만 접근이 가능하
		this.right = right;
	}
	
	public void sum() {
		System.out.println(this.left + this.right);
	}
	
	public void avg() {
		System.out.println((this.left + this.right)/2);
	}
}


public class Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c1 = new Calculator();
		c1.setOperands(10, 20);
		c1.sum();
		c1.avg();
		
		Calculator c2 = new Calculator();
		c2.setOperands(20, 40);
		c2.sum();
		c2.avg();
		
		
	}

}
