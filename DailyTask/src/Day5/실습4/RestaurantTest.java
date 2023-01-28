package Day5.실습4;

public class RestaurantTest {
	public static void main(String[] args) {
		KoreanRestaurant korres1 = new KoreanRestaurant(101, "을밀대", "서울", "물냉면", 9, "010-717-9999", "No");
		KoreanRestaurant korres2 = new KoreanRestaurant(102, "도꼭지", "서울", "도미솥밥", 8, "010-717-8888", "15:00~17:00");
		Restaurant res1 = new Restaurant(401, "도마29", "대구", "연어초밥", 8);
		Restaurant res2 = new Restaurant(301, "마포리 1987", "서울", "마포리 스테이크", 7);
		Restaurant res3 = new Restaurant(601, "성심당", "대전", "튀김소보로", 8);

		Review rev1 = new Review(1, 101, "김싸피", "너무 맛있네요.");
		Review rev2 = new Review(2, 401, "나싸피", "연어초밥은 여기가 최고!");

		// 리스팅하기
		RestaurantManager rm = new RestaurantManager();

		rm.addRestaurant(res3);
		rm.addRestaurant(res2);
		rm.addRestaurant(res1);
		rm.addRestaurant(korres2);
		rm.addRestaurant(korres1);
		System.out.println("*************************모든 맛집 목록*************************");
		for (Restaurant r : rm.getRestaurantList()) {
			System.out.println(r);
		}

		System.out.println("\n*************************한식 맛집 목록*************************");

		for (KoreanRestaurant kr : rm.getKoreanRestaurantList()) {
			System.out.println(kr);
		}

		System.out.println("\n*************************일반 맛집 목록*************************");
		for (Restaurant r : rm.getNonKoreanRestaurantList()) {
			System.out.println(r);
		}

		System.out.println("\n*************************브레이크 타임이 있는 목록*************************");

		for (KoreanRestaurant r : rm.getKoreanRestaurantList()) {
			if (!(r.getBreakTime().equals("No")))
				System.out.println(r);
		}

	}
}
