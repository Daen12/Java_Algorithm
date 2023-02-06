package feb0204_revision;

public class test2 {
	public static void main(String[] args) {
//		long a = 200;
//		float b = (float)a;
//		System.out.println(b);
		
		int[] nums = {10};
		try {
			System.out.println(nums[2]);
		} catch(Exception e) {
			e.getCause();
		}
	}
}
