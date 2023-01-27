package jan27.실습2;

public class MovieTest {
	//test는 꼭 main 함수 안에서!
	public static void main(String[] args) {
		Movie m1 = new Movie();
		m1.setId(1);
		m1.setTitle("Ssafy Life");
		m1.setDirector("Daen");
		m1.setGenre("Reality");
		m1.setRunningTime(120);
				
		Movie m2 = new Movie(2, "Home Life", "Dayoung", "Reality", 100);
		SeriesMovie m3 = new SeriesMovie(3, "Sejong Life", "Diane", "Reality", 80, 10, "ep.3");
		
		System.out.println("======== toString ========");
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());

		System.out.println("======== add & getList ========");
		
		IMovieManager mm = MovieManagerImpl.getInstance();
		
		mm.add(m1);
		mm.add(m2);
		mm.add(m3);

		//타입 명시 & 배열일 경우 하나씩 꺼내 프린트   
		Movie[] movieList = mm.getList();
		for(Movie m : movieList) {
			System.out.println(m);
		}
		System.out.println("======== Search by title ========");
		
		Movie[] searched = mm.searchByTitle("Ssaf");
		for(Movie c : searched) {
			System.out.println(c);
		}
		
		System.out.println("======== Search general movies ========");
		Movie[] generalMovies = mm.getMovies();
		for(Movie m : generalMovies) {
			System.out.println(m);
		}
		
		System.out.println("======== Search Series movies ========");
		//여기서. 왜 Movie / SeriesMovie define 관계없이 SeriesMovie 클래스로 프린트되는지?
		Movie[] seriesMovies = mm.getSeriesMovies();
		for(Movie m : seriesMovies) {
			System.out.println(m);
		}
		
		System.out.println("======== calculate avg running time ========");
		double avg = mm.getRunningTimeAvg();
		System.out.println(avg);

	}
}


