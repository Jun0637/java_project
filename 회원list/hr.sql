DROP TABLE todolist;
DROP TABLE personal;
DROP SEQUENCE todolist_seq;

CREATE TABLE personal
(
    email  VARCHAR2(20) PRIMARY KEY
    , passwd VARCHAR2(20) NOT NULL
    , usrname VARCHAR2(20) NOT NULL
);

CREATE TABLE todolist
(
    seqno NUMBER PRIMARY KEY
    , email VARCHAR2(20) NOT NULL REFERENCES personal(email) ON DELETE CASCADE
    , regdate DATE DEFAULT sysdate
    , todo VARCHAR2(3000) DEFAULT '할일 없음'
    , importance VARCHAR2(10) CHECK (importance IN ( '높음', '보통', '낮음')) 
    , categories CHAR(6) DEFAULT '개인' CHECK (categories IN ( '개인', '회사')) 
);

CREATE SEQUENCE todolist_seq;

INSERT INTO personal (email, passwd,usrname)
    VALUES('sonie@gmail.com', 'sonie','손흥민');
INSERT INTO personal (email, passwd,usrname)
    VALUES('kimya@gmail.com', 'kimya','김연아');

INSERT INTO todolist (seqnon, email,todo, importance, categories)
    VALUES(todolist_seq.NEXTVAL,'sonie@gmail.com', '프로젝트 기획안 문서', '높음','개인');
INSERT INTO todolist (seqnon, email,todo, importance, categories)
    VALUES(todolist_seq.NEXTVAL,'kimya@gmail.com','프로젝트 미팅', '낮음','개인');


select * from personal;
INSERT INTO todolist (seqno, email,todo, importance, categories)
    VALUES(todolist_seq.NEXTVAL,'aa','프로젝트 미팅', '낮음','개인');
commit;


