package global.scit.LibraryProject.service;

import java.util.List;

import global.scit.LibraryProject.dao.LibraryDAO;
import global.scit.LibraryProject.vo.Book;
import global.scit.LibraryProject.vo.Rent;
import global.scit.LibraryProject.vo.Users1;


public class LibraryService {
	LibraryDAO dao = new LibraryDAO();

	public List<Book> Allbook() {
		List<Book> list = dao.Allbook();
		return list;
	}

	public int registbook(Book vo) {
		int result = dao.registbook(vo);
		return result;
	}

	public int delete(String isbn) {
		int result = dao.delete(isbn);
		return result;
	}

	public Book selectIsbn(String isbn) {
		Book vo = dao.selectIsbn(isbn);
		return vo;
	}

	public int update(Book b) {
		int result = dao.update(b);
		return result;
	}

	public int rentbook(Book b) {
		int result = dao.rentbook(b);
		return result;
	}

	public int returnbook(Book b) {
		int result = dao.returnbook(b);
		return result;
	}

	public List<Rent> Allrent() {
		List<Rent> list = dao.Allrent();
		return list;
	}

	public int updateRent(Rent to) {
		int result = dao.updateRent(to);
		return result;
	}

	public Users1 selectId(String usrid) {
		Users1 vo = dao.selectId(usrid);
		return vo;
	}

	public int deleteRent(Rent to) {
		int result = dao.deleteRent(to);
		return result;
	}

	public Rent findIdisbn(String usrid) {
		Rent vo = dao.findIdisbn(usrid);
		return vo;
	}


}
