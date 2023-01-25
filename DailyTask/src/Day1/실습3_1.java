package Day1;

public class 실습3_1 {
	public static void main(String[] args) {
		String space = "    ";
		int num = 1;
		for(int i=0; i<5; i++) {
			
			for(int j=0; j<i; j++) {
				System.out.print(space);
			}
			for(int k=i; k<5; k++) {
				System.out.printf("%-4s",num);
				num++;
			}
			System.out.println();
			
		}
	}

}
