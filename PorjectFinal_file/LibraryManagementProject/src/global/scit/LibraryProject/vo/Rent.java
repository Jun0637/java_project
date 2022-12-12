package global.scit.LibraryProject.vo;

public class Rent {
    private int rentnum;
    private String rentdate; 
    private String returndate; 
    private String usrid; 
    private String isbn;
    
    private int stock;
    
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Rent(int rentnum, String rentdate, String returndate, String usrid, String isbn, int stock) {
		super();
		this.rentnum = rentnum;
		this.rentdate = rentdate;
		this.returndate = returndate;
		this.usrid = usrid;
		this.isbn = isbn;
		this.stock = stock;
	}

	public Rent() { 
	}
	
	public Rent(String usrid, String isbn) {
		this.usrid = usrid;
		this.isbn = isbn;
	}
	public Rent(int rentnum, String rentdate, String returndate, String usrid, String isbn) {
		super();
		this.rentnum = rentnum;
		this.rentdate = rentdate;
		this.returndate = returndate;
		this.usrid = usrid;
		this.isbn = isbn;
	}
	public int getRentnum() {
		return rentnum;
	}
	public String getRentdate() {
		return rentdate;
	}
	public String getReturndate() {
		return returndate;
	}
	public String getUsrid() {
		return usrid;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setRentnum(int rentnum) {
		this.rentnum = rentnum;
	}
	public void setRentdate(String rentdate) {
		this.rentdate = rentdate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	
	@Override
	public String toString() {

		return  rentnum +"\t" + isbn +"\t"+ usrid +"\t"+ rentdate +"\t"+ returndate;

	}  
}		

