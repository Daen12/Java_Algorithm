package Day5.실습2;

public class SeriesMovie extends Movie{
	private int seriesNum;
	private String episode;
	
	public SeriesMovie(){
		
	}
	public SeriesMovie(int id, String title, String director, String genre, int runningTime, int seriesNum, String episode) {
		//super는 조상의 변수를 끌어와줌. *super(variable lists)*
		super(id, title, director, genre, runningTime);
		this.seriesNum = seriesNum;
		this.episode = episode;
		
	}
	public int getSeriesNum() {
		return seriesNum;
	}
	public void setSeriesNum(int seriesNum) {
		this.seriesNum = seriesNum;
	}
	public String getEpisode() {
		return episode;
	}
	public void setEpisode(String episode) {
		this.episode = episode;
	}
	//toString() 만들때 조상클래스에서 private 설정한 변수들은 getVariable()를 통해 가져오기!
	@Override
	public String toString() {
		return "SeriesMovie [id="+this.getId()+", title="+this.getTitle()+", director="+this.getDirector()+", genre="+this.getGenre()+", runningTime"+this.getRunningTime()+", seriesNum=" + seriesNum + ", episode=" + episode + "]";
	}
	
	
}
