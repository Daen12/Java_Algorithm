package Day6.실습4;

public interface IRestaurantManager {
	boolean addRestaurant(Restaurant restaurant);
	
	boolean removeRestaurant(int resid);
	
	Restaurant[] getRestaurantList();
	
	Restaurant searchByResid(int resid);
	
	KoreanRestaurant[] getKoreanRestaurantList();
	
	Restaurant[] getNonKoreanRestaurantList();
	
	
}
