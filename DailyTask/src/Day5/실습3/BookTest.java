package Day5.실습3;

public class BookTest {
	public static void main(String[] args) {
		Book firstbook = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본문법");
		Book secondbook = new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용");		
		Book thirdbook = new Book("35355","English", "소나무", "jaen.kr",30000,"SW 기본 문법");
		Magazine forthbook = new Magazine("45678", "Monthly Algo", "홍길동", "jaen.kr", 30000, "SW 모델링", 2021, 1);
		
		System.out.println("**********************도서 전체 목록**********************");
		
		BookManager bm = new BookManager();
		
		bm.add(firstbook);
		bm.add(secondbook);
		bm.add(thirdbook);
		bm.add(forthbook);
		
		for(Book b : bm.getList()) {
			System.out.println(b);
		}
		System.out.println("********************일반 도서 목록**********************");
		
		for(Book b : bm.getBooks()) {
			System.out.println(b);
		}

		System.out.println("********************잡지 목록**********************");
		for(Magazine b : bm.getMagazines()) {
			System.out.println(b);
		}
		
		System.out.println("***************도서 제목 포함 검색 : java*****************");
		for(Book b : bm.searchByTitle("Java")) {
			System.out.println(b);
		}
		
		System.out.println("***************도서 총합 및 평균*****************");

		System.out.println("도서 가격 총합 : " + bm.getTotalPrice());
		System.out.println("도서 가격 평균 : " + bm.getPriceAvg());
		
		
	}
}
