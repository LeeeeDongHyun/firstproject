package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //해당 클래스는 스프링부트와 연동되어 테스팅된다.
class ArticleServiceTest {


    @Autowired ArticleService articleService;
    @Test
    void index() {
        //예상 시나리오
        Article a =  new Article(1L, "동현","자바");
        Article b =  new Article(2L, "강민","파이썬");
        Article c =  new Article(3L, "해수","C");
        Article d =   new Article(4L, "은","HTML");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c,d));
        //실제 결과
        List<Article> articles = articleService.index();

        //비교
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_성공__존재하는_id_입력() {
        //예상
        Long id = 1L;
        Article expected = new Article(id,"동현","자바");

        //실제
        Article article = articleService.show(id);
        //비교
        assertEquals(expected.toString(), article.toString());
    }
    @Test
    void show_실패_존재하지_않는_id_입력() {
        //예상
        Long id = -1L;
        Article expected = null;

        //실제
        Article article = articleService.show(id);
        //비교
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void create_성공__title과_content만_있는_dto_입력() {
        //예상
        String title = "차차차";
        String content = "1234";
        ArticleForm dto =  new  ArticleForm(null,title, content);
        Article expected = new Article(5L, title, content);

        //실제
        Article article = articleService.create(dto);
        //비교
        assertEquals(expected.toString(), article.toString());

    }
    @Test
    @Transactional
    void create_실패__id가_포함된_dto를_입력() {
        //예상
        String title = "챠챠챠";
        String content = "12345";
        ArticleForm dto = new ArticleForm(4L, title, content);
        Article expected = null;

        //실제
        Article article = articleService.create(dto);
        //비교
        assertEquals(expected, article);
    }


}
