package Day4.실습4;

public class RestaurantTest {
	public static void main(String[] args) {
		Restaurant res1 = new Restaurant(101, "을밀대", "서울", "냉면", 4);
		Restaurant res2 = new Restaurant(401, "도마29", "대구", "연어초밥", 3);
		Review rev1 = new Review(1, 101, "김싸피", "너무 맛있네요.");
		Review rev2 = new Review(2, 401, "나싸피", "연어초밥은 여기가 최고!");
		
		
		System.out.println("*************************맛집목록*************************");
		System.out.println(res1.toString());
		System.out.println(res2.toString());
		
		System.out.println("*************************리뷰목록*************************");
		System.out.println(rev1.toString());
		System.out.println(rev2.toString());
		
		RestaurantManager rm = new RestaurantManager();
		rm.addRestaurant(res1);
		rm.addRestaurant(res2);
		rm.addReview(rev1);
		rm.addReview(rev2);
		
		System.out.println("\n-- Search by resid 101 --");
		System.out.println(rm.searchByResid(101));
		
		System.out.println(rm.removeRestaurant(401));
		System.out.println(rm.removeReview(1)); //리뷰는 1번째 지워야 함.
		
		System.out.println("-- Restaurant 401 & Review1 removed --");

		for(Restaurant r : rm.getRestaurantList()) {
			System.out.println(r);
		}
		
		System.out.println("-- get restaurant review 401 --");
		
		//형태가 review[] 배열로 반환되므로for 루프를 돌려서 하나씩뽑아야 함!!
//		for(Review r : rm.getRestaurantReview(401)) {
//			System.out.println(r);
//		}
		
		System.out.println("-- 101 restaurant updated --");
		Restaurant res = new Restaurant(101, "을밀대", "대전", "냉면", 4);
		System.out.println(rm.updateRestaurant(res));
		for(Restaurant r : rm.getRestaurantList()) {
			System.out.println(r);
		}

		
		
		
	}

}