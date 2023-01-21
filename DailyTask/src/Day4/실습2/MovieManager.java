package Day4.실습2;

public class MovieManager {
	int MAX_SIZE = 100;
	int size = 0;
	Movie[] movieList = new Movie[MAX_SIZE];
	
	//리턴 타입이 없을때는 void
	public void add(Movie movie) {
		if(size<100) {
			movieList[size++] = movie;
		} else {
			System.out.println("등록 가능한 최대 영화정보가 들어있습니다.");
		}
	}
	
	//리턴타입이 배열일때는 []
	public Movie[] getList() {
		Movie[] result = new Movie[size];
		for(int i=0; i<size; i++) {
			result[i] = movieList[i];
		}
		return result;
	}
	//영화 제목으로 영화정보를 반환하는 메서드
	//영화정보를 add해야 영화를 검색할 수 있으므로 
	//size는 등록된 영화 수 만큼 증가한 상태   
	public Movie[] searchByTitle(String title) {
		int cnt = 0;
		for(int i=0; i<size; i++) {
			if(movieList[i].getTitle().contains(title)) {
				cnt++;
			}
		}
		Movie[] result = new Movie[cnt];
		int index = 0;
		for(int i=0; i<size; i++) {
			if(movieList[i].getTitle().equals(title)) {
				result[index++] = movieList[i];
			}
		}
		return result;
		
	}
}
