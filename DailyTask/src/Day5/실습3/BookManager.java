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
	public Book[] remove(String isbn) {
		int index = 0;
		//finding a index to be removed
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
		return array;
		
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
}
