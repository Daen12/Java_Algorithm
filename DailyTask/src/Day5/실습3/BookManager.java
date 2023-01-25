package Day5.실습3;

import java.util.Arrays;

public class BookManager {
	private int MAX_SIZE = 100;
	private int size = 0;
	private Book[] books = new Book[MAX_SIZE];
	
	public void add(Book book) {
		if(size<100) {
			books[size++] = book;
		} else {
			System.out.println("memory overload");
		}
	}
	public void remove(String isbn) {
		int index = 0;
		//finding an index to be removed
		for(int i=0; i<this.size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				index = i;
			}
		}
		//create another array and move elements from books
		Book[] array = new Book[this.size-1];
		for(int i=0, k=0; i<this.size; i++) {
			if(i == index) continue;
			array[k++] = books[i];
		}
		books = array;
		
	}
	public Book[] getList() {
		return Arrays.copyOfRange(books, 0, size);
	}
	public Book[] searchByIsbn(String isbn) {
		int cnt = 0;
		
		for(int i=0; i<this.size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				cnt++;
			}
		}
		if(cnt == 0) return null;
		
		int idx = 0;
		Book[] result = new Book[cnt];
		
		for(int i=0; i<this.size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				result[idx++] = books[i]; 
			}
		}
		return result;
	}
	
	public Book[] searchByTitle(String title) {
		int cnt = 0;
		for(int i=0; i<this.size; i++) {
			if(books[i].getTitle().contains(title)) {
				cnt++;
			}
		}
		if(cnt == 0) return null;
		
		int idx = 0;
		Book[] result = new Book[cnt];
		
		for(int i=0; i<this.size; i++) {
			if(books[i].getTitle().contains(title)) {
				result[idx++] = books[i];
			}
		}
		return result;
	}
	
	public Magazine[] getMagazines() {
		int cnt = 0;
		for(int i=0; i<this.size; i++) {
			if(books[i] instanceof Magazine) {
				cnt++;
			}
		}
		if(cnt == 0) return null;
		
		int idx = 0;
		Magazine[] result = new Magazine[cnt];
		
		for(int i=0; i<this.size; i++) {
			if(books[i] instanceof Magazine) {
				result[idx++] = (Magazine)books[i];
			}
		}
		return result;
	}
	public Book[] getBooks() {
		int cnt = 0;
		for(int i=0; i<this.size; i++) {
			if(!(books[i] instanceof Magazine)) {
				cnt++;
			}
		}
		if(cnt == 0) return null;
		
		int idx = 0;
		Book[] result = new Book[cnt];
		
		for(int i=0; i<this.size; i++) {
			if(!(books[i] instanceof Magazine)) {
				result[idx++] = books[i];
			}
		}
		return result;
	}
	public int getTotalPrice() {
		int total = 0;
		for(int i=0; i<this.size; i++) {
			total+= books[i].getPrice();
		}
		return total;
	}
	public double getPriceAvg() {
		return this.getTotalPrice()/this.size;
	}
}
