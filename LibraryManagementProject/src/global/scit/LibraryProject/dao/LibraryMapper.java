package global.scit.LibraryProject.dao;

import java.util.List;

import global.scit.LibraryProject.vo.Book;
	public interface LibraryMapper {
		public int registbook(Book vo);
		public List<Book> Allbook();
		public int update(Book vo);
		public int delete(int numbers);
		public int returnbook(int numbers);
		public Book selectOne(int numbers);
		public Book selectIsbn(String isbn);
}