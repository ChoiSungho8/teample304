- 회원
create table member(
      userid varchar2(50),
      userpw varchar2(100) not null,
      username varchar2(100) not null,
	  userphone varchar2(30) not null,
      regdate date default sysdate,
      updatedate date default sysdate
);

-- 기본키 제약 조건명 : pk_member_userid, --회원에 관련된 모든 정보 삭제
alter table member add constraint pk_member_userid primary key (userid);

-- 회원가입 쿼리 확인
insert into member(userid, userpw, username, userphone) values('테스트', '1234', '테스트', '1234');
insert into member(userid, userpw, username, userphone) values('테스트2', '1234', '테스트2', '1234');
insert into member(userid, userpw, username, userphone) values('테스트3', '1234', '테스트3', '1234');
insert into member(userid, userpw, username, userphone) values('테스트4', '1234', '테스트4', '1234');
select * from MEMBER;

- 게시판
-- 게시판 일련번호 생성
create sequence seq_board;

create table board (
  bno number(10,0),--게시글 번호
  title varchar2(200) not null,--게시글 제목
  content varchar2(2000) not null,--게시글 내용
  userid varchar2(50) not null,--게시글 작성자
  visitcount number(10) not null,--조회수
  regdate date default sysdate,--게시글 최조 작성일
  updatedate date default sysdate--게시글 수정일
);

-- 기본키 제약 조건명 : pk_board_bno
alter table board add constraint pk_board_bno primary key (bno);
-- 참조키 제약 조건명 : pk_member_userid
alter table board add constraint fk_member_userid foreign key (userid) references member(userid) on delete cascade;


-- 더미 데이터 추가
insert into board (bno, title, content, userid, visitcount) values (seq_board.nextval, '더미 게시글 제목', '더미 게시글 내용', '테스트', 0);
insert into board (bno, title, content, userid, visitcount) values (seq_board.nextval, '더미 게시글 제목2', '더미 게시글 내용2', '테스트2', 0);
insert into board (bno, title, content, userid, visitcount) values (seq_board.nextval, '더미 게시글 제목3', '더미 게시글 내용3', '테스트3', 0);
insert into board (bno, title, content, userid, visitcount) values (seq_board.nextval, '더미 게시글 제목4', '더미 게시글 내용4', '테스트4', 0);
select * from board;


- 댓글
-- 댓글 일련번호 생성
create sequence seq_reply;

create table reply (
  rno number(10,0), 
  bno number(10,0) not null,
  reply varchar2(1000) not null,
  replyer varchar2(50) not null, 
  replyDate date default sysdate, 
  updateDate date default sysdate
);

-- 댓글 기본키 제약 조건명 : pk_reply_rno
alter table reply add constraint pk_reply_rno primary key (rno);
-- 댓글 참조키 제약 조건명 : fk_reply_board_bno
alter table reply  add constraint fk_reply_board foreign key (bno) references board (bno) on delete cascade; 

insert into reply (rno, bno, reply, replyer) values (seq_reply.nextval, 2, 'ㅋㅋ', '테스트2');
insert into reply (rno, bno, reply, replyer) values (seq_reply.nextval, 2, 'ㅋㅋ', '테스트2');
insert into reply (rno, bno, reply, replyer) values (seq_reply.nextval, 3, 'ㅋㅋ', '테스트3');
insert into reply (rno, bno, reply, replyer) values (seq_reply.nextval, 4, 'ㅋㅋ', '테스트4');

select userid, userpw, username, userphone from MEMBER where userid='테스트' and userpw='1234';