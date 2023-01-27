package jan27.실습2;

public interface IMovieManager {
	void add(Movie movie);
	
	Movie[] getList();
	
	Movie[] getMovies();
	
	Movie[] searchByTitle(String title);
	
	Movie[] getSeriesMovies();
	
	Double getRunningTimeAvg();
	
}

