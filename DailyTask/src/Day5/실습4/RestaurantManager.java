package Day5.실습4;

import java.util.Arrays;

public class RestaurantManager {
	private int MAX_RESTAURANT_SIZE = 100;
	private int MAX_REVIEW_SIZE = 1000;
	private int restaurantSize = 0;
	private int reviewSize = 0;
	// 멤버변수랑 매개변수랑 이름 같을때 this를 쓰면 클래스에서 선언된 변수를 뜻한다.
	private Restaurant[] Restaurants = new Restaurant[MAX_RESTAURANT_SIZE];
	private Review[] Reviews = new Review[MAX_REVIEW_SIZE];

	// 코리안 레스토랑만 반환하는 메서드
	public KoreanRestaurant[] getKoreanRestaurantList() {
		int cnt = 0;
		for (int i = 0; i < restaurantSize; i++) {
			if (Restaurants[i] instanceof KoreanRestaurant)
				cnt++;
			
		}
		if(cnt==0) return null;
		KoreanRestaurant[] res = new KoreanRestaurant[cnt];
		for(int i=0, k=0; i<restaurantSize; i++) {
			if(Restaurants[i] instanceof KoreanRestaurant) {
				res[k++] = (KoreanRestaurant) Restaurants[i];
			}
		}
		return res;
	}
	//일반 레스토랑 리턴하는 함수
	public Restaurant[] getNonKoreanRestaurantList() {
		int t = 0;
		for (int i = 0; i < restaurantSize; i++) {
			if (!(Restaurants[i] instanceof KoreanRestaurant))
				t++;
			
		}
		if(t==0) return null;
		Restaurant[] result = new Restaurant[t];
		for(int i=0, k=0; i<restaurantSize; i++) {
			if(!(Restaurants[i] instanceof KoreanRestaurant)) {
				result[k++] = Restaurants[i];
			}
		}
		return result;
	}

	// 메서드 만들기
	// boolean을 리턴하는 add restaurant
	public boolean addRestaurant(Restaurant restaurant) {
		if (restaurantSize < 100) {
			Restaurants[restaurantSize++] = restaurant;
			return true;
		} else {
			System.out.println("Warning! Memory overload!");
			return false;
		}
	}

	// 일치하는 resid가 없을때 index=0이 유지되어 에러..?
	// 테스트해보기
	public boolean removeRestaurant(int resid) {
		int index = 0;
		boolean flag = false;
		for (int i = 0; i < restaurantSize; i++) {
			if (Restaurants[i].getResid() == resid) {
				index = i;
				flag = true;
			}
		}
		Restaurant[] newArray = new Restaurant[restaurantSize - 1];
		for (int i = 0, k = 0; i < restaurantSize; i++) {
			if (i == index)
				continue;
			newArray[k++] = Restaurants[i];
		}

		Restaurants = newArray;
		--restaurantSize;
		return flag;
	}

	// remove review
	public boolean removeReview(int reviewid) {
		int index = 0;
		boolean flag = false;
		for (int i = 0; i < this.reviewSize; i++) {
			if (Reviews[i].getReviewid() == reviewid) {
				index = i;
				flag = true;
			}
		}
		Review[] newArray = new Review[--this.reviewSize];
		for (int i = 0, k = 0; i < this.reviewSize; i++) {
			if (i == index)
				continue;
			newArray[k++] = Reviews[i];
		}
		Reviews = newArray;
		return flag;
	}

	// get restaurant list
	public Restaurant[] getRestaurantList() {
		return Arrays.copyOfRange(Restaurants, 0, restaurantSize);
	}

	// get restaurant by resid
	public Restaurant getRestaurant(int resid) {
		int target = 0;
		for (int i = 0; i < this.restaurantSize; i++) {
			if (Restaurants[i].getResid() == resid) {
				target = i;
				break;
			}
		}
		return Restaurants[target];

	}

	// search by resid
	public Restaurant searchByResid(int resid) {
		int idx = 0;
		for (int i = 0; i < restaurantSize; i++) {
			if (Restaurants[i].getResid() == resid) {
				idx = i;
				break;
			}

		}
		return Restaurants[idx];
	}

	// update restaurant
	public boolean updateRestaurant(Restaurant update) {
		boolean flag = false;
		for (int i = 0; i < this.restaurantSize; i++) {
			if (Restaurants[i].getResid() == update.getResid()) {
				Restaurants[i] = update;
				flag = true;
				break;
			}
		}
		return flag;
	}

	// add review
	public boolean addReview(Review review) {
		if (reviewSize < 1000) {
			Reviews[reviewSize++] = review;
			return true;
		} else {
			System.out.println("Warning! Memory overload!");
			return false;
		}
	}

	// get restaurant review
	// 맛집 하나에 대한 리뷰는 여러개.
	public Review[] getRestaurantReview(int resid) {
		// 먼저 일치하는 리뷰의 개수를 파악하기
		int cnt = 0;
		for (int i = 0; i < reviewSize; i++) {
			if (Reviews[i].getResid() == resid)
				cnt++;
		}
		if (cnt == 0)
			return null;

		Review[] list = new Review[cnt];
		for (int i = 0, j = 0; i < reviewSize; i++) {
			if (Reviews[i].getResid() == resid) {
				list[j++] = Reviews[i];
			}
		}
		return list;
	}
	public int getRestaurantSize() {
		return restaurantSize;
	}
	public void setRestaurantSize(int restaurantSize) {
		this.restaurantSize = restaurantSize;
	}

}
