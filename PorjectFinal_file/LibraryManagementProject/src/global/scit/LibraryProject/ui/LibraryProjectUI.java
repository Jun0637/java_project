package global.scit.LibraryProject.ui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import global.scit.LibraryProject.service.LibraryService;
import global.scit.LibraryProject.vo.Book;
import global.scit.LibraryProject.vo.Rent;
import global.scit.LibraryProject.vo.Users1;

public class LibraryProjectUI {
	Scanner keyin = new Scanner(System.in);
	LibraryService service = new LibraryService();
	String isbn, usrid, usrpw;

	public LibraryProjectUI() {

		String choice;

		while (true) {
			menu1();
			choice = keyin.next();

			switch (choice) {
			case "1":
				manager();// 관리자 모드
				break;
			case "2":
				user();// 이용자 모드
				break;
			case "0": // 종료
				System.out.println(" 프로그램 종료합니다.");
				System.exit(0);
			default:
				System.out.println("** 다시 선택해 주세요. ");
			}
		}
	}

	private void user() {
		String choice;
		menu3();
		choice = keyin.next();

		switch (choice) {
		case "1":
			rentbook();// 대여
			break;
		case "2":
			returnbook();// 반납
			break;
		case "3":
			return; // 뒤로가기
		case "0":// 종료
			System.out.println(" 프로그램 종료합니다.");
			System.exit(0);
		default:
			System.out.println("** 다시 선택해 주세요. ");
		}
	}

	// 이용자모드] 2.반납
	private void returnbook() {

		try {
			System.out.print(" 아이디 : ");
			usrid = keyin.next();

			Users1 user = service.selectId(usrid);

			if (user == null) {
				System.out.println("** 등록된 아이디가 없습니다.");
				keyin.nextLine();
				return;
			}

			selectIsbn();
			if (deleteRent(usrid, isbn) != 1) {
				return;
			}

			Book vo = service.selectIsbn(isbn);
			Book b = new Book(isbn, vo.getStock() + 1);

			int result = service.returnbook(b);
			if (result == 1) {
				System.out.println(" 책이 반납되었습니다.");
			} else {
				System.out.println("** 책 대여 실패하였습니다.");
			}
		} catch (Exception e) {
			System.out.println("아이디를 다시 입력해 주세요.");
			e.printStackTrace();
		}
	}

	private int deleteRent(String usrid, String isbn) {
		Rent to = new Rent(usrid, isbn);
		int result = service.deleteRent(to);

		return result;
	}

	// 이용자모드] 대여
	private void rentbook() {
		int stock = 0;
		Allbook();
		System.out.println("\n [ 도서 대여 ]");

		System.out.print(" 대여할 책 ISBN : ");
		isbn = keyin.next();
		// 책이 현재 도서관에 있는지 검색
		Book vo = service.selectIsbn(isbn);
		if (vo == null) {
			System.out.println("** 찾으시는 책이 없습니다.");
			return;
		}
		// 찾은 책 리스트
		System.out.println(vo);
		// 찾은 책의 재고 확인
		if (vo.getStock() < 1) {
			System.out.println("** 대여불가합니다.");
			return;
		}
		System.out.print(" 아이디 : ");
		usrid = keyin.next();
		System.out.print(" 비밀번호 : ");
		usrpw = keyin.next();

		// id가 있는지 DB조회
		Users1 user = service.selectId(usrid);
		if (user == null) {
			System.out.println("** 아이디가 없습니다.");
			keyin.nextLine();
			return;
		}

		// id랑 비번 일치 조회
		if (!(user.getUsrpw().equals(usrpw))) {
			System.out.println("** 비밀번호가 틀렸습니다.");
			return;
		}
		// 여기까지 isbn으로 책검색후 찾은 책 수량이 있는 것까지 확인,
		// id랑 비밀번호도 일치하는지 확인
		// id랑 isbn이 rent테이블에 없으면 대출가능, 있으면 불가.
		Rent us = service.findIdisbn(usrid);

		if (us != null) {
			if (us.getIsbn().equals(isbn)) {
				System.out.println("** 같은 책은 한 아이디당 한권만 대출할 수 있습니다.");
				return;
			}
		}
		updateRent();

		Book b = new Book(vo.getIsbn(), vo.getStock() - 1);
		int result = service.rentbook(b);
		if (result == 1) {
			System.out.println(" 책이 대여되었습니다.");
		} else {
			System.out.println("** 책 대여를 실패하였습니다.");
		}
	}

	private int updateRent() {

		Rent to = new Rent(usrid, isbn);
		int result = service.updateRent(to);
		if (result != 1) {
			System.out.println("** 책 대여를 실패하였습니다.");
		}
		return result;

	}

	// 관리자
	private void manager() {

		String password;
		System.out.print("비밀번호 : ");
		password = keyin.next();
		if (!(password.equals("admin"))) {
			System.out.println("** 관리자 로그인 실패");
			return;
		}

		System.out.println("관리자 로그인 성공");

		while (true) {
			menu2();

			String choice;
			choice = keyin.next();

			switch (choice) {
			case "1":
				Allbook();// 도서 목록조회
				break;
			case "2":
				registbook();// 도서 등록
				break;
			case "3":
				delete(); // 도서 삭제
				break;
			case "4":
				update(); // 도서 재고 수정
				break;
			case "5":
				Allrent();// 대출한 도서 조회
				break;
			case "6":
				return;
			case "0":// 종료

				System.out.println(" ** 프로그램 종료합니다.");
				System.exit(0); // 리턴하라고하심
			default:
				System.out.println(" ** 다시 선택해 주세요. ");
			} // end switch
		}
	}

	private void Allrent() {
		System.out.println("\n [ 대출한 도서 조회 ]");

		List<Rent> list = service.Allrent();

		if (list.isEmpty()) {
			System.out.println(" ** 조회할 책이 없습니다.");
			return;
		}
		System.out.println("대여번호\tISBN\t아이디\t빌린 날짜\t\t\t반납 예정 날짜");
		for (Rent b : list) {
			System.out.println(b);
		}
	}

	// isbn으로 검색
	private void selectIsbn() {

		System.out.print("ISBN입력 : ");
		isbn = keyin.next();

		Book vo = service.selectIsbn(isbn);

		if (vo == null) {
			System.out.println("** 책이 없습니다.");
			return;
		}
		System.out.println(vo);
	}

	// 관리자 모드]4.도서 재고 수정
	private void update() {
		String isbn;
		int stock;
		System.out.println(" ISBN 번호 : ");
		isbn = keyin.next();

		Book vo = service.selectIsbn(isbn);

		if (vo == null) {
			System.out.println(" **해당 책이 없습니다.");
			return;
		}
		try {
			System.out.println(" 재고 수량 : ");
			stock = keyin.nextInt();

			Book vo1 = new Book(isbn, stock);
			int result = service.update(vo1);

			if (result == 1) {
				System.out.println(" 수정 완료되었습니다.");
			} else {
				System.out.println(" **수정 오류입니다.");
			}
		} catch (Exception e) {
			System.out.println(" 숫자로 입력하세요");
		}
	}

	// 관리자모드] 3.도서 삭제
	private void delete() {
		System.out.println("\n [ 도서 삭제 ]");
		String isbn;

		System.out.print(" ISBN 입력 : ");
		isbn = keyin.next();

		Book vo = service.selectIsbn(isbn);
		if (vo == null) {
			System.out.println("** 책이 없습니다.");
			return;
		}
		int result = service.delete(isbn);
		if (result == 1) {
			System.out.println("** 책이 삭제되었습니다.");
			return;
		}
		System.out.println("** 책 삭제 작업을 실패하였습니다.");

	}

	// 관리자 모드] 2. 도서 등록
	private void registbook() {
		System.out.println("   [도서 등록]   ");
		String isbn, title, author, bookcom;
		int stock;

		try {
			System.out.print(" ISBN : ");
			isbn = keyin.next();
			keyin.nextLine();
			Book ro = service.selectIsbn(isbn);
			if (ro != null) {
				System.out.println("** 등록할 수 없는 책입니다.");
				return;
			}

			System.out.print(" 책 제목 : ");
			title = keyin.nextLine();
			System.out.print(" 지은이 : ");
			author = keyin.nextLine();
			System.out.print(" 출판사 : ");
			bookcom = keyin.nextLine();
			System.out.print(" 수량 : ");
			stock = keyin.nextInt();
			keyin.nextLine();

			Book vo = new Book(isbn, title, author, bookcom, stock);

			int result = service.registbook(vo);
			if (result == 1) {
				System.out.println(" 도서 등록되었습니다.");
				System.out.println(vo);
			} else
				System.out.println("** 도서 등록 실패입니다.");

		} catch (InputMismatchException e) {
			System.out.println("도서를 다시 등록해주세요.");
			return;
		} catch (Exception e) {
			System.out.println("도서를 다시 등록해주세요.");
			return;
		}
	}

	// 관리자모드]1. 도서 목록 조회
	private void Allbook() {
		System.out.println("\n [ 도서 목록 조회 ]");

		List<Book> list = service.Allbook();

		if (list.isEmpty()) {
			System.out.println("** 조회할 책이 없습니다.");
			return;
		}
		System.out.println("ISBN\t책 제목\t\t지은이\t출판사\t재고");
		for (Book b : list) {
			System.out.println(b);
		}
	}

	// 메뉴화면

	// menu1 : 초기화면
	private void menu1() {
		System.out.println("------------------------");
		System.out.println("      [ SCIT 도서관 ]     ");
		System.out.println();
		System.out.println(" 1. 관리자 모드  2. 이용자 모드  0. 종료 ");
		System.out.println();
		System.out.println("------------------------");
		System.out.print("   > 선택 : ");
	}

	// menu2 : 관리자모드
	private void menu2() {
		System.out.println("------------------------");
		System.out.println("      [ 관리자 모드 ]     ");
		System.out.println();
		System.out.println("   1. 도서 목록 조회");
		System.out.println("   2. 도서 등록");
		System.out.println("   3. 도서 삭제");
		System.out.println("   4. 도서 재고 수정");
		System.out.println("   5. 대출한 도서 목록");
		System.out.println("   6. 뒤로가기");
		System.out.println("   0. 종     료");
		System.out.println();
		System.out.println("------------------------");
		System.out.print("   > 선택 : ");
	}

	// menu3 : 이용자모드
	private void menu3() {
		System.out.println("------------------------");
		System.out.println("      [ 이용자 모드 ]     ");
		System.out.println();
		System.out.println("   1. 대     여");
		System.out.println("   2. 반     납");
		System.out.println("   3. 뒤로가기");
		System.out.println("   0. 종     료");
		System.out.println();
		System.out.println("------------------------");
		System.out.print("   > 선택 : ");
	}
}