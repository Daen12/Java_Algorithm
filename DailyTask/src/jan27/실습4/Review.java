package jan27.실습4;

public class Review {
	//코드를 작성해주세요.  
	int reviewid;
	int resid;
	String writer;
	String content;
	
	public Review() {
		
	}
	public Review(int reviewid, int resid, String writer, String content) {
		this.reviewid = reviewid;
		this.resid = resid;
		this.writer = writer;
		this.content = content;
	}
	
	public String toString() {
		String str = String.format("Review [reviewid=%s, resid=%s, writer=%s, content=%s]",this.reviewid, this.resid, this.writer, this.content);
		return str;
	}
	public int getReviewid() {
		return reviewid;
	}
	public void setReviewid(int reviewid) {
		this.reviewid = reviewid;
	}
	public int getResid() {
		return resid;
	}
	public void setResid(int resid) {
		this.resid = resid;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
   
}
