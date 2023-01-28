package jan27.실습4;

public class RestaurantTest {
	public static void main(String[] args) {
		KoreanRestaurant korres1 = new KoreanRestaurant(101, "을밀대", "서울", "물냉면", 9, "010-717-9999", "No");
		KoreanRestaurant korres2 = new KoreanRestaurant(102, "도꼭지", "서울", "도미솥밥", 8, "010-717-8888", "15:00~17:00");
		Restaurant res1 = new Restaurant(401, "도마29", "대구", "연어초밥", 8);
		Restaurant res2 = new Restaurant(301, "마포리 1987", "서울", "마포리 스테이크", 7);
		Restaurant res3 = new Restaurant(601, "성심당", "대전", "튀김소보로", 8);

		Review rev1 = new Review(1, 101, "김싸피", "너무 맛있네요.");
		Review rev2 = new Review(2, 401, "나싸피", "연어초밥은 여기가 최고!");
		Review rev3 = new Review(3, 601, "박싸피", "대전 오면 성심당 안 갈 수 없죠!");
		Review rev4 = new Review(4, 101, "이싸피", "깔끔합니다.");

		// 리스팅하기
		RestaurantManagerImpl rm = RestaurantManagerImpl.getInstance();

		rm.addRestaurant(korres1);
		rm.addRestaurant(res3);
		rm.addRestaurant(res2);
		rm.addRestaurant(res1);
		rm.addRestaurant(korres2);
		
		rm.addReview(rev2);
		rm.addReview(rev1);
		rm.addReview(rev3);
		rm.addReview(rev4);
		
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
		System.out.println("\n*************************을밀대 리뷰 목록*************************");
		for(Review re : rm.getRestaurantReview(101)) {
			System.out.println(re);
		}
		
		System.out.println("\n*************************도마29 리뷰 목록*************************");
		for(Review re : rm.getRestaurantReview(401)) {
			System.out.println(re);
		}
		
		System.out.println("\n*************************성심당 리뷰 목록*************************");
		for(Review re : rm.getRestaurantReview(601)) {
			System.out.println(re);
		}

		System.out.println("\n*************************브레이크 타임이 있는 목록*************************");

		for (KoreanRestaurant r : rm.getKoreanRestaurantList()) {
			if (!(r.getBreakTime().equals("No")))
				System.out.println(r);
		}
		System.out.println("\n*************************업데이트 테스트*************************");
		Restaurant res = new Restaurant(101, "을밀대", "대전", "물냉면", 9);
		rm.updateRestaurant(res);
		for(Restaurant r : rm.getRestaurantList()) {
			System.out.println(r);
		}
	}
}
