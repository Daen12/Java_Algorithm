package jan27.실습3;

/**
 * 도서리스트를 배열로 유지하며 관리하는 클래스
 */
import java.util.*;
public class BookManagerImpl implements IBookManager {
	
	private int MAX_SIZE = 100;
	private List<Book> books = new ArrayList<>();
	private int size = 0;
	
	//싱글턴으로 생성
	private static BookManagerImpl instance = new BookManagerImpl();
	
	//외부 접근 불가한 생성자
	private BookManagerImpl() {
		
	}
	//인스턴스 가져오는 메서드
	public static BookManagerImpl getInstance() {
		return instance;
	}
	
	public void add(Book book) {
		if(books.size()<MAX_SIZE) {
			books.add(book);
		} else {
			System.out.println("memory overload");
		}
	}
	public void remove(String isbn) {
		for(int i=0; i<books.size(); i++) {
			if(books.get(i).getIsbn().equals(isbn)) books.remove(books.get(i));
		}
	}
	public Book[] getList() {
		Book[] res = new Book[books.size()];
		return books.toArray(res);
	}
	public Book searchByIsbn(String isbn) {

		for(int i=0; i<books.size(); i++) {
			if(books.get(i).getIsbn().equals(isbn))return books.get(i);
		}
		return null;
	}
	
	public Book[] searchByTitle(String title) {
		List<Book> temp = new ArrayList<>();
		for(int i=0; i<books.size(); i++) {
			if(books.get(i).getTitle().contains(title)) temp.add(books.get(i));
		}
		
		Book[] res = new Book[temp.size()];
		return temp.toArray(res);
	}
	
	public Magazine[] getMagazines() {
		List<Magazine> temp = new ArrayList<>();
		for(int i=0; i<books.size(); i++) {
			if(books.get(i) instanceof Magazine) temp.add((Magazine) books.get(i));
		}
		
		Magazine[] mag = new Magazine[temp.size()];
		
		return temp.toArray(mag);
	}
	public Book[] getBooks() {
		List<Book> temp = new ArrayList<>();
		for(int i=0; i<books.size(); i++) {
			if(!(books.get(i) instanceof Magazine)) temp.add(books.get(i));
		}
		
		Book[] res = new Book[temp.size()];
		
		return temp.toArray(res);
	}
	public int getTotalPrice() {
		int total = 0;
		for(Book b : books) {
			total+=b.getPrice();
		}
		return total;
	}
	public double getPriceAvg() {
		return getTotalPrice()/books.size();
	}
}


