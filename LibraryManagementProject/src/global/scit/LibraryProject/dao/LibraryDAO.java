package global.scit.LibraryProject.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import global.scit.LibraryProject.vo.Book;



public class LibraryDAO {
	SqlSessionFactory factory = MybatisConfig.getSessionFactory();

	public int registbook(Book vo) {
		SqlSession session = null;
		
		session = factory.openSession();
		LibraryMapper mapper = session. getMapper(LibraryMapper.class);
		int result = mapper.registbook(vo);
		
		session.commit();
		
		return result;
	}

	public List<Book> Allbook() {
		SqlSession session = null;
		
		session = factory.openSession();
		LibraryMapper mapper = session. getMapper(LibraryMapper.class);
		List<Book> list = mapper.Allbook();
			
		return list;
	}

	public int delete(int numbers) {
		SqlSession session = null;
		
		session = factory.openSession();
		LibraryMapper mapper = session. getMapper(LibraryMapper.class);
		int result = mapper.delete(numbers);
		
		session.commit();
		
		return result;
	}

	public int returnbook(int numbers) {
		SqlSession session = null;
		
		session = factory.openSession();
		LibraryMapper mapper = session. getMapper(LibraryMapper.class);
		int result = mapper.returnbook(numbers);
		
		session.commit();
		
		return result;
	}

	public Book selectOne(int numbers) {
		SqlSession session = null;
		
		session = factory.openSession();
		LibraryMapper mapper = session. getMapper(LibraryMapper.class);
		Book vo = mapper.selectOne(numbers);
		
		return vo;

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

	public int rentbook(int numbers) {
		SqlSession session = null;
		
		session = factory.openSession();
		LibraryMapper mapper = session. getMapper(LibraryMapper.class);
		int result = mapper.returnbook(numbers);
		
		session.commit();
		
		return result;
	}

}