package Day5.실습3;

public class Magazine extends Book {
	//Generate getters and setters only with added values.
	private int year;
	private int month;

	Magazine() {

	}

	Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year, int month) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}

	@Override
	public String toString() {
		// string format으로 바꿔줌.
		String str = String.format("%-8s |%-10s |%-4s |%-10s |%-8s |%-10s |%5s |%5s", this.getIsbn(), this.getTitle(), this.getAuthor(), this.getPublisher(), this.getPrice(), this.getDesc(), this.year, this.month);
		return str;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

}
