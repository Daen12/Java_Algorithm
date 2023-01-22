package Day5.실습2;

import java.util.Arrays;

public class MovieManager {
	private final int MAX_SIZE = 100;
	private int size = 0;
	private Movie[] movieList = new Movie[MAX_SIZE];
	
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
		return Arrays.copyOfRange(movieList,0,size);
	}
	//instanceof 'Movie'를 하면 seriesMovie도 포함됨. 반드시 !(not) SeriesMovie를 활용하기.
	public Movie[] getMovies() {
		int cnt = 0;
		for(int i=0; i<this.size; i++) {
			if(!(movieList[i] instanceof SeriesMovie)) {
				cnt++;
			}
		}
		
		if(cnt == 0) return null;
		
		Movie[] generalMovies = new Movie[cnt];
		int idx = 0;
		for(int i=0; i<this.size; i++) {
			if(!(movieList[i] instanceof SeriesMovie)) {
				generalMovies[idx++] = movieList[i];
			}
		}
		return generalMovies;
	}
	
	
	public Movie[] getSeriesMovies() {
		int cnt = 0;
		for(int i=0; i<this.size; i++) {
			if(movieList[i] instanceof SeriesMovie) {
				cnt++;
			}
		}
		if(cnt == 0) return null;
		
		SeriesMovie[] seriesMovies = new SeriesMovie[cnt];
		int idx = 0;
		for(int i=0; i<this.size; i++) {
			if(movieList[i] instanceof SeriesMovie) {
				seriesMovies[idx++] = (SeriesMovie)movieList[i];
			}
		}
		return seriesMovies;
	}
	public double getRunningTimeAvg() {
		double sum = 0;
		for(int i=0; i<this.size; i++) {
			sum+=movieList[i].getRunningTime();
		}
		return sum/this.size;
	}
	//영화 제목으로 영화정보를 반환하는 메서드
	//영화정보를 add해야 영화를 검색할 수 있으므로 
	//size는 등록된 영화 수 만큼 증가한 상태   
	public Movie[] searchByTitle(String title) {
		
		int cnt = 0;
		
		for(int i=0; i<this.size; i++) {
			if(movieList[i].getTitle().contains(title)) {
				cnt++;
			}
		}
		if (cnt == 0) return null;
		
		Movie[] result = new Movie[cnt];
		
		int index = 0;
		for(int i=0; i<this.size; i++) {
			if(movieList[i].getTitle().contains(title)) {
				result[index++] = movieList[i];
			}
		}
		return result;
		
	}
}
