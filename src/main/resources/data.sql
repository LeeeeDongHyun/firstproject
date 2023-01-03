insert into Article(id, title, content) values(1,'동현', '자바');
insert into Article(id, title, content) values(2,'강민', '파이썬');
insert into Article(id, title, content) values(3,'해수', 'C');
insert into Article(id, title, content) values(4,'은', 'HTML');


--article 더미데이터
insert into Article(id, title, content) values(5, '당신의 인생 음식?', '댓글 ㄱㄱㄱ');
insert into Article(id, title, content) values(6, '당신의 혈액형은?', '댓글 ㄱㄱ');
insert into Article(id, title, content) values(7, '당신의 키는?', '댓글 ㄱ');

--comment 더미데이터
----5번 게시글의 댓글들
insert into Comment(id, article_id, nickname, body) values(1, 5, 'Lee', '제육');
insert into Comment(id, article_id, nickname, body) values(2, 5, 'Min', '국밥');
insert into Comment(id, article_id, nickname, body) values(3, 5, 'Kang', '떡볶이');
insert into Comment(id, article_id, nickname, body) values(4, 5, 'Chae', '닭가슴살');


----6번 게시글의 댓글들
insert into Comment(id, article_id, nickname, body) values(5, 6, 'Lee', 'B');
insert into Comment(id, article_id, nickname, body) values(6, 6, 'Min', 'B');
insert into Comment(id, article_id, nickname, body) values(7, 6, 'Kang', 'AB');
insert into Comment(id, article_id, nickname, body) values(8, 6, 'Chae', 'AB');

----6번 게시글의 댓글들
insert into Comment(id, article_id, nickname, body) values(9, 7, 'Lee', '182');
insert into Comment(id, article_id, nickname, body) values(10, 7, 'Min', '175');
insert into Comment(id, article_id, nickname, body) values(11, 7, 'Kang', '167');
insert into Comment(id, article_id, nickname, body) values(12, 7, 'Chae', '150');




