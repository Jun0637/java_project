package global.scit.LibraryProject.vo;

public class BookQuantity {
	private int number; // 책 일련번호
	private String title; // 도서제목
	private int stock; // 재고

	public BookQuantity() {
	}

	public BookQuantity(int number, String title, int stock) {
		this.number = number;
		this.title = title;
		this.stock = stock;
	}

	public int getNumber() {
		return number;
	}

	public String getTitle() {
		return title;
	}

	public int getStock() {
		return stock;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "bookQuantity [number=" + number + ", title=" + title + ", stock=" + stock + "]";
	}

}