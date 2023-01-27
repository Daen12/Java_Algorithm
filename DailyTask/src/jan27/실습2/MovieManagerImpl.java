package jan27.실습2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieManagerImpl implements IMovieManager {
	
	//인터페이스를 적용하여 클래스의 인스턴스를 싱글턴으로 하나 생성
	private List<Movie> movieList = new ArrayList<>();
	
	private static MovieManagerImpl instance = new MovieManagerImpl();
	
	//외부에서 접근 불가능하도록 생성자 만들기.
	private MovieManagerImpl(){
		
	}
	//getInstance 메서드를 통해서만 인스턴스에 접근 가능하도록 하기.
	//static을 지정해줘야 Test파일에서 인스턴스 안만들고 바로 접근 가능.
	public static MovieManagerImpl getInstance() {
		return instance;
	}
	
	//리턴 타입이 없을때는 void
	@Override
	public void add(Movie movie) {
		movieList.add(movie);
	}
	
	//리턴타입이 배열일때는 []
	//이거 잘 리턴되는지 확인해보기.
	@Override
	public Movie[] getList() {
		Movie[] res = new Movie[movieList.size()];
		for(int i=0; i<movieList.size(); i++) {
			res[i] = movieList.get(i);
		}
		return res;
	}
	
	//instanceof 'Movie'를 하면 seriesMovie도 포함됨. 반드시 !(not) SeriesMovie를 활용하기.
	
	@Override
	public Movie[] getMovies() {
		List<Movie> templist = new ArrayList<>();
		
		for(int i=0; i<movieList.size(); i++) {
			if(!(movieList.get(i) instanceof SeriesMovie)) templist.add(movieList.get(i));
		}
		Movie[] res = new Movie[templist.size()];
		
		return templist.toArray(res);
		
	}
	
	@Override
	public SeriesMovie[] getSeriesMovies() {
			List<SeriesMovie> templist = new ArrayList<>();
			
			for(int i=0; i<movieList.size(); i++) {
				if(movieList.get(i) instanceof SeriesMovie) templist.add((SeriesMovie) movieList.get(i));
			}
			SeriesMovie[] res = new SeriesMovie[templist.size()];
			
			return templist.toArray(res);
			
		}
	
	@Override
	public Double getRunningTimeAvg() {
		double sum = 0;
		for(int i=0; i<movieList.size(); i++) {
			sum+=movieList.get(i).getRunningTime();
		}
		return sum/movieList.size();
	}
	//영화 제목으로 영화정보를 반환하는 메서드
	//영화정보를 add해야 영화를 검색할 수 있으므로 
	//size는 등록된 영화 수 만큼 증가한 상태  
	
	@Override
	public Movie[] searchByTitle(String title) {
		List<Movie> temp = new ArrayList<>();
		
		for(int i=0; i<movieList.size(); i++) {
			if(movieList.get(i).getTitle().contains(title)) temp.add(movieList.get(i));
		}
		
		Movie[] res = new Movie[temp.size()];
		
		return temp.toArray(res);
		
	}
}

