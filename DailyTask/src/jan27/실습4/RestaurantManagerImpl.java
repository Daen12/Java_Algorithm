package jan27.실습4;

import java.util.*;

public class RestaurantManagerImpl implements IRestaurantManager {
	private int MAX_RESTAURANT_SIZE = 100;
	private int MAX_REVIEW_SIZE = 1000;

	// 멤버변수랑 매개변수랑 이름 같을때 this를 쓰면 클래스에서 선언된 변수를 뜻한다.
	private List<Restaurant> Restaurants = new ArrayList<>();
	private List<Review> Reviews = new ArrayList<>();
	private static RestaurantManagerImpl instance = new RestaurantManagerImpl();

	private RestaurantManagerImpl() {

	}

	public static RestaurantManagerImpl getInstance() {
		return instance;
	}

	// 코리안 레스토랑만 반환하는 메서드
	public KoreanRestaurant[] getKoreanRestaurantList() {
		List<KoreanRestaurant> templist = new ArrayList<>();
		for (int i = 0; i < Restaurants.size(); i++) {
			if (Restaurants.get(i) instanceof KoreanRestaurant)
				templist.add((KoreanRestaurant) Restaurants.get(i));
		}
		KoreanRestaurant[] res = new KoreanRestaurant[templist.size()];
		return templist.toArray(res);
	}

	// 일반 레스토랑 리턴하는 함수
	public Restaurant[] getNonKoreanRestaurantList() {
		List<Restaurant> templist = new ArrayList<>();
		for (int i = 0; i < Restaurants.size(); i++) {
			if (!(Restaurants.get(i) instanceof KoreanRestaurant))
				templist.add(Restaurants.get(i));
		}
		Restaurant[] res = new Restaurant[templist.size()];
		return templist.toArray(res);
	}

	// 메서드 만들기
	// boolean을 리턴하는 add restaurant
	public void addRestaurant(Restaurant restaurant) {
		if (Restaurants.size() < MAX_RESTAURANT_SIZE) {
			Restaurants.add(restaurant);
		} else {
			System.out.println("Warning! Memory overload!");
		}
	}
	// add review
	public void addReview(Review review) {
		if (Reviews.size() < MAX_REVIEW_SIZE) {
			Reviews.add(review);
		} else {
			System.out.println("Warning! Memory overload!");
		}
	}
	//Remove Restaurant
	public void removeRestaurant(int resid) {

		for (int i = 0; i < Restaurants.size(); i++) {
			if (Restaurants.get(i).resid == resid)
				Restaurants.remove(Restaurants.get(i));
		}
	}

	// remove review
	public void removeReview(int reviewid) {

		for (int i = 0; i < Reviews.size(); i++) {
			if (Reviews.get(i).reviewid == reviewid) Reviews.remove(Reviews.get(i));
		}
	}

	// get restaurant list
	public Restaurant[] getRestaurantList() {
		Restaurant[] list = new Restaurant[Restaurants.size()];
		return Restaurants.toArray(list);
	}
	// get restaurant review
	// 맛집 하나에 대한 리뷰는 여러개.
	public Review[] getRestaurantReview(int resid) {
		Review[] list = new Review[Reviews.size()];
		return Reviews.toArray(list);
	}
	// search by resid
	public Restaurant searchByResid(int resid) {
		int idx = 0;
		for(int i=0; i<Restaurants.size(); i++) {
			if(Restaurants.get(i).resid == resid) idx = i;
		}
		 return Restaurants.get(idx);
	}

	// update restaurant -> resid로 일치여부 판단 후 swap 해주기.
	public void updateRestaurant(Restaurant update) {
		for(int i=0; i<Restaurants.size(); i++) {
			if(Restaurants.get(i).resid == update.resid) Restaurants.set(i, update);
		}
	}
}
