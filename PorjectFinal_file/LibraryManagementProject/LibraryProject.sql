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
    VALUES('cc','cc','�����','010-1234-1234');
    
    
INSERT INTO USERS1 (usrid, usrpw, usrname, usrphone)
    VALUES('scit','scit','����','010-7777-7777');
    
INSERT INTO USERS1 (usrid, usrpw, usrname, usrphone)
    VALUES('it','it','����','010-5577-5577');    

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
VALUES('a','Ʈ���� �ڸ��� 2023', '�賭��','�̷��� â',3);


INSERT INTO Book (isbn, title, author, bookcom, stock)
VALUES('b','�ƹ����� �ع�����', '������','â��',1);

INSERT INTO Book (isbn, title, author, bookcom, stock)
VALUES('c','������ ������', '��ȣ��','����������',4);
    
INSERT INTO Book (isbn, title, author, bookcom, stock)
VALUES('d','���翡 �д� ��ü', '������','����Ͻ�',5);
INSERT INTO Book (isbn, title, author, bookcom, stock)
    VALUES('e','������', '��û','���������Ͽ콺',5);
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
    TITLE AS "å����",
       AUTHOR      AS "������",
	   BOOKCOM      AS "���ǻ�",
       stock      AS "����"
FROM Book;



COMMIT;

SELECT* FROM BOOK;
SELECT* FROM rent;
SELECT* FROM USERS1;
