package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest //JPA와 연동한 테스트!
class CommentRepositoryTest {

    @Autowired CommentRepository commentRepository;
    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        /* Case 1: 5번 게시글의 모든 댓글 조회 */
        {
            //입력데이터 준비
            Long articleId = 5L;
            //실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            //예상하기
            Article article = new Article(5L, "당신의 인생 음식?","댓글 ㄱㄱㄱ");
            Comment a = new Comment(1L, article, "Lee", "제육");
            Comment b = new Comment(2L, article, "Min", "국밥");
            Comment c = new Comment(3L, article, "Kang", "떡볶이");
            Comment d = new Comment(4L, article, "Chae", "닭가슴살");
            List <Comment> expected = Arrays.asList(a,b,c,d);

            //검증
            assertEquals(expected.toString(), comments.toString(), "5번 글의 모든 댓글을 출력");
        }

        /*Case 2: 1번 게시글의 모든 댓글 조회 */
        {
            //입력데이터 준비
            Long articleId = 1L;
            //실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            //예상하기
            Article article = new Article(1L, "동현","자바");
            List <Comment> expected = Arrays.asList();

            //검증
            assertEquals(expected.toString(), comments.toString(), "1번 글은 댓글이 없음");
        }
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        /* Case 1: "Lee"의 모든 댓글 조회 */
        {
            //입력 데이터를 준비
            String nickname = "Lee";
            //실제 수행
           List<Comment> comments = commentRepository.findByNickname(nickname);
            //예상하기
            Comment a = new Comment(1L, new Article(5L, "당신의 인생 음식?","댓글 ㄱㄱㄱ"), nickname, "제육");
            Comment b = new Comment(5L, new Article(6L, "당신의 혈액형은?","댓글 ㄱㄱ"), nickname, "B");
            Comment c = new Comment(9L, new Article(7L, "당신의 키는?","댓글 ㄱ"), nickname, "182");
            List <Comment> expected = Arrays.asList(a,b,c);

            //검증
            assertEquals(expected.toString(), comments.toString(),"Lee의 모든 댓글을 출력");
        }
    }
}