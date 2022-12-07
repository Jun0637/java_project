package global.scit.LibraryProject.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RentVO {
	private int rent_number;
	private int user_number;
	private int book_number;
	private String rent_date;
	private String rent_return_date;
	private char rent_return_yn;
	private int book_stock;
	
	public RentVO() {}
	
	public RentVO(int rent_number, int user_number, int book_number, String rent_date, int book_stock) {
		this.rent_number = rent_number;
		this.user_number = user_number;
		this.book_number = book_number;
		this.rent_date = rent_date;
		this.book_stock = book_stock;
		
		
		calcReturndate();
		calcReturnyn();		
	}

	public int getRent_number() {
		return rent_number;
	}

	public int getUser_number() {
		return user_number;
	}

	public int getBook_number() {
		return book_number;
	}

	public String getRent_date() {
		return rent_date;
	}

	public int getBook_stock() {
		return book_stock;
	}

	public void setRent_number(int rent_number) {
		this.rent_number = rent_number;
	}

	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}

	public void setBook_number(int book_number) {
		this.book_number = book_number;
	}

	public void setRent_date(String rent_date) {
		this.rent_date = rent_date;
	}

	public void setBook_stock(int book_stock) {
		this.book_stock = book_stock;
	}
	
	public void calcReturndate() {
		
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //날짜 포멧	
		Calendar cal = Calendar.getInstance(); //날짜 계산을 위해 Calendar 추상클래스 선언 getInstance()메소드 사용	
		
		Date dt=null;
		try {
			dt = simpleDate.parse(this.rent_date);
		} catch (ParseException e) {
						e.printStackTrace();
		}
        
		cal.setTime(dt);	
		cal.add(Calendar.DATE, 10);
		String date = simpleDate.format(cal.getTime());		

		this.rent_return_date = date; 

	}
	
	public void calcReturnyn() {
			if(book_stock >= 1) {rent_return_yn = 'O';}
			else {rent_return_yn = 'X';}
	}

}