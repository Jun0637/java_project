DROP TABLE BOOK;
DROP TABLE USERS1;
DROP TABLE RENT;


CREATE TABLE USERS1
(
    usrid VARCHAR2(30) PRIMARY KEY,
    usrpw VARCHAR2(30),
    usrname VARCHAR2(30),
    usrphone VARCHAR2(30)
);

INSERT INTO USERS1 (usrid, usrpw, usrname, usrphone)
    VALUES('cc','cc','손흥민','010-1234-1234');
    
    
INSERT INTO USERS1 (usrid, usrpw, usrname, usrphone)
    VALUES('scit','scit','제니','010-7777-7777');
    
INSERT INTO USERS1 (usrid, usrpw, usrname, usrphone)
    VALUES('it','it','유주','010-5577-5577');    

COMMIT;
    SELECT * FROM USERS1;

CREATE TABLE BOOK
(
    isbn VARCHAR2(30) PRIMARY KEY,
    title VARCHAR2(30) NOT NULL,
    author VARCHAR2(30) NOT NULL,
    bookcom VARCHAR2(30) NOT NULL,
    stock NUMBER DEFAULT 0
);
select * from book;

INSERT INTO Book (isbn, title, author, bookcom, stock)
VALUES('a','트렌드 코리아 2023', '김난도','미래의 창',3);


INSERT INTO Book (isbn, title, author, bookcom, stock)
VALUES('b','아버지의 해방일지', '정지아','창비',1);

INSERT INTO Book (isbn, title, author, bookcom, stock)
VALUES('c','불편한 편의점', '김호연','나무옆의자',4);
    
INSERT INTO Book (isbn, title, author, bookcom, stock)
VALUES('d','마흔에 읽는 니체', '장재형','유노북스',5);
INSERT INTO Book (isbn, title, author, bookcom, stock)
    VALUES('e','역행자', '자청','웅진지식하우스',5);
commit;

	SELECT
		isbn, title, author, bookcom, stock
    FROM 
		book;
        
        
CREATE TABLE RENT
(
    rentnum NUMBER PRIMARY KEY,
    rentdate DATE DEFAULT sysdate,
    returndate DATE DEFAULT sysdate+10,
    usrid VARCHAR2(30) REFERENCES USERS1(usrid),
    isbn VARCHAR2(30) REFERENCES BOOK(isbn)
);

INSERT INTO RENT(rentnum,usrid,isbn)
VALUES (RENT_seq.NEXTVAL, 'cc', 'a');

DELETE FROM Book
WHERE isbn = 'e';

DROP SEQUENCE RENT_seq;

SELECT * FROM RENT;

COMMIT;

CREATE SEQUENCE RENT_seq;

	SELECT
		r.rentnum, r.isbn, r.usrid, r.rentdate, r.returndate, b.stock
    FROM 
		rent r, users1 u,book b
	WHERE
		r.usrid = u.usrid
		AND
		b.isbn= r.isbn;

SELECT 
    TITLE AS "책제목",
       AUTHOR      AS "지은이",
	   BOOKCOM      AS "출판사",
       stock      AS "수량"
FROM Book;



COMMIT;

SELECT* FROM BOOK;
SELECT* FROM rent;
SELECT* FROM USERS1;
