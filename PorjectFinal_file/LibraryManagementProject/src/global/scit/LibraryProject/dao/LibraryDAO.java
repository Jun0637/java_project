package global.scit.LibraryProject.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import global.scit.LibraryProject.vo.Book;
import global.scit.LibraryProject.vo.Rent;
import global.scit.LibraryProject.vo.Users1;




public class LibraryDAO {
	SqlSessionFactory factory = MybatisConfig.getSessionFactory();

	public int registbook(Book vo) {
		SqlSession session = null;
		
		session = factory.openSession();
		LibraryMapper mapper = session. getMapper(LibraryMapper.class);
		int result = mapper.registbook(vo);
		
		session.commit();
		session.close();
		
		return result;
	}

	public List<Book> Allbook() {
		SqlSession session = null;
		
		session = factory.openSession();
		LibraryMapper mapper = session. getMapper(LibraryMapper.class);
		List<Book> list = mapper.Allbook();
			
		return list;
	}

	public int delete(String isbn) {
		SqlSession session = null;
		
		session = factory.openSession();
		LibraryMapper mapper = session. getMapper(LibraryMapper.class);
		int result = mapper.delete(isbn);
		
		session.commit();
		
		return result;
	}

	public Book selectIsbn(String isbn) {
		SqlSession session = null;
		
		session = factory.openSession();
		LibraryMapper mapper = session. getMapper(LibraryMapper.class);
		Book vo = mapper.selectIsbn(isbn);
		
		return vo;
	}

	public int update(Book vo1) {
		SqlSession session = null;
		
		session = factory.openSession();
		LibraryMapper mapper = session. getMapper(LibraryMapper.class);
		int result = mapper.update(vo1);
		
		session.commit();
		
		return result;
	}

	public int rentbook(Book b) {
		SqlSession session = null;
		
		session = factory.openSession();
		LibraryMapper mapper = session. getMapper(LibraryMapper.class);
		int result = mapper.rentbook(b);
		
		session.commit();
		
		return result;
	}

	public int returnbook(Book b) {
		SqlSession session = null;
		
		session = factory.openSession();
		LibraryMapper mapper = session. getMapper(LibraryMapper.class);
		int result = mapper.returnbook(b);
		
		session.commit();
		
		return result;
	}

	public List<Rent> Allrent() {
		SqlSession session = null;
		
		session = factory.openSession();
		LibraryMapper mapper = session. getMapper(LibraryMapper.class);
		List<Rent> list = mapper.Allrent();
			
		return list;
	}

	public int updateRent(Rent to) {
		SqlSession session = null;
		
		session = factory.openSession();
		LibraryMapper mapper = session. getMapper(LibraryMapper.class);
		int result = mapper.updateRent(to);
		
		session.commit();
		
		return result;
	}

	public Users1 selectId(String usrid) {
		SqlSession session = null;
		
		session = factory.openSession();
		LibraryMapper mapper = session. getMapper(LibraryMapper.class);
		Users1 vo = mapper.selectId(usrid);
		
		return vo;
	}

	public int deleteRent(Rent to) {
		SqlSession session = null;
		
		session = factory.openSession();
		LibraryMapper mapper = session. getMapper(LibraryMapper.class);
		int result = mapper.deleteRent(to);
		
		session.commit();
		
		return result;
	}

	public Rent findIdisbn(String usrid) {
		SqlSession session = null;
		
		session = factory.openSession();
		LibraryMapper mapper = session. getMapper(LibraryMapper.class);
		Rent vo = mapper.findIdisbn(usrid);
		
		return vo;
	}
}
