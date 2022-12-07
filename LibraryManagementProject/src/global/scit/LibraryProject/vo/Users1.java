package global.scit.LibraryProject.vo;

public class Users1 {
	private String user_id;
	private String user_password;
	private int user_number;
	private String user_name;
	private String user_phonenum;
	private String user_mail;
	private String user_rented_book;
	private int user_rented_book_quantity;
	
	public Users1() {
	}

	public Users1(String user_id, String user_password, int user_number, String user_name, String user_phonenum,
			String user_mail, String user_rented_book, int user_rented_book_quantity) {
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_number = user_number;
		this.user_name = user_name;
		this.user_phonenum = user_phonenum;
		this.user_mail = user_mail;
		this.user_rented_book = user_rented_book;
		this.user_rented_book_quantity = user_rented_book_quantity;
	}

	public String getUserid() {
		return user_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public int getUser_number() {
		return user_number;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getUser_phonenum() {
		return user_phonenum;
	}

	public String getUser_mail() {
		return user_mail;
	}

	public String getUser_rented_book() {
		return user_rented_book;
	}

	public int getUser_rented_book_quantity() {
		return user_rented_book_quantity;
	}

	public void setUserid(String user_id) {
		this.user_id = user_id;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public void setUser_phonenum(String user_phonenum) {
		this.user_phonenum = user_phonenum;
	}

	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	public void setUser_rented_book(String user_rented_book) {
		this.user_rented_book = user_rented_book;
	}

	public void setUser_rented_book_quantity(int user_rented_book_quantity) {
		this.user_rented_book_quantity = user_rented_book_quantity;
	}

	@Override
	public String toString() {
		return "Users1 [user_id=" + user_id + ", user_password=" + user_password + ", user_number=" + user_number
				+ ", user_name=" + user_name + ", user_phonenum=" + user_phonenum + ", user_mail=" + user_mail
				+ ", user_rented_book=" + user_rented_book + ", user_rented_book_quantity=" + user_rented_book_quantity
				+ "]";
	}
	
	

    
}

/*
USER_ID VARCHAR2(20) NOT NULL,
USER_PASSWORD VARCHAR2(20) NOT NULL,
USER_NUMBER	NUMBER PRIMARY KEY, --회원 (일련)번호  
USER_NAME	VARCHAR2(30) NOT NULL, -- 회원 이름
USER_PHONENUM	VARCHAR2(15), --폰번호
USER_MAIL	VARCHAR2(50), --이메일
USER_RENTED_BOOK VARCHAR2(20),-- 대여 도서명
USER_RENTED_BOOK_QUANTITY NUMBER --대여 도서권수
*/