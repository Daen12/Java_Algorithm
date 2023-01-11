import java.util.Scanner;

public class Q10871_bronze5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int standard = sc.nextInt();
//		int[] array = new int[count];
//		for (int i = 0; i < count; i++) {
//			array[i] = sc.nextInt();
//		}
//
//		for (int e : array) {
//			if (e < standard) {
//				System.out.print(e + " ");
//				
//			}
//		}
		//위의 코드를 더 간결하게!
		for(int i=0; i<count; i++) {
			int target = sc.nextInt();
			if(target<standard) {
				System.out.print(target + " ");
			}
		}
		
		sc.close();
	}

}
