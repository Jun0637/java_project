package global.scit.LibraryProject.vo;

public class Users1 {
	private String usrid;
	private String usrpw;
	private String usrname;
	private String usrphone;
	public Users1() {
	}
	
	public Users1(String usrid, String usrpw) {
		super();
		this.usrid = usrid;
		this.usrpw = usrpw;
	}

	public Users1(String usrid, String usrpw, String usrname, String usrphone) {
		super();
		this.usrid = usrid;
		this.usrpw = usrpw;
		this.usrname = usrname;
		this.usrphone = usrphone;
	}
	public String getUsrid() {
		return usrid;
	}
	public String getUsrpw() {
		return usrpw;
	}
	public String getUsrname() {
		return usrname;
	}
	public String getUsrphone() {
		return usrphone;
	}
	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}
	public void setUsrpw(String usrpw) {
		this.usrpw = usrpw;
	}
	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}
	public void setUsrphone(String usrphone) {
		this.usrphone = usrphone;
	}
	@Override
	public String toString() {
		return "Users1 [usrid=" + usrid + ", usrpw=" + usrpw + ", usrname=" + usrname + ", usrphone=" + usrphone + "]";
	}

}
