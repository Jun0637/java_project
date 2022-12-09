package global.scit.LibraryProject.dao;

import java.util.List;

import global.scit.LibraryProject.vo.Book;
import global.scit.LibraryProject.vo.Rent;
import global.scit.LibraryProject.vo.Users1;



public interface LibraryMapper {
	public int registbook(Book vo);
	public List<Book> Allbook();
	public int update(Book vo);
	public int delete(String isbn);
	public Book selectIsbn(String isbn);
	public int rentbook(Book b);
	public int returnbook(Book b);
	public List<Rent> Allrent();
	public int updateRent(Rent to);
	public Users1 selectId(String usrid);
	public int deleteRent(Rent to);
	public Rent findIdisbn(String usrid);
}
