package Day4.실습2;

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
		
		System.out.println("======== toString ========");
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println("======== add & getList ========");
		
		MovieManager mm = new MovieManager();
		
		mm.add(m1);
		mm.add(m2);
		
		//타입 명시 & 배열일 경우 하나씩 꺼내 프린
		Movie[] movieList = mm.getList();
		for(Movie m : movieList) {
			System.out.println(m);
		}
		System.out.println("======== Search by title ========");
		
		Movie[] searched = mm.searchByTitle("Ssaf Life");
		for(Movie c : searched) {
			System.out.println(c);
		}
		

		

		
	}

}
