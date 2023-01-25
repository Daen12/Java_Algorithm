package Day4.실습3;

public class BookTest {
	public static void main(String[] args) {
		Book firstbook = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본문법");
		Book secondbook = new Book("35355","english", "김하나", "jaen.kr",30000,"SW 기본 문법");
		
		System.out.println("**********************도서목록**********************");
		System.out.println(firstbook.toString());
		System.out.println(secondbook.toString());
		
		BookManager bm = new BookManager();
		
		bm.add(firstbook);
		bm.add(secondbook);
		System.out.println("********************Get List**********************");

		for(Book b : bm.getList()) {
			System.out.println(b);
		}
		System.out.println("********************Remove**********************");

		bm.remove("21424");
		
		for(Book b : bm.getList()) {
			System.out.println(b);
		}
		
		System.out.println("********************Search**********************");

		for(Book b : bm.searchByIsbn("35355")) {
			System.out.println(b);
		}		
	}
}
