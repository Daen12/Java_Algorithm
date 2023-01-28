package jan27.실습4;

public interface IRestaurantManager {
	void addRestaurant(Restaurant restaurant);
	
	void removeRestaurant(int resid);
	
	Restaurant[] getRestaurantList();
	
	Restaurant searchByResid(int resid);
	
	KoreanRestaurant[] getKoreanRestaurantList();
	
	Restaurant[] getNonKoreanRestaurantList();
	
	
}
