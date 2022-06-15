package com.jojoldu.book.freelecspringboot2webservice.doamin.post;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public  void clanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void sava(){
        //given

        //when

        //then
    }

    @Test
    public void 게시글_저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        String author = "theking9494@naver.com";
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();
        Posts posts = postsList.get(0);

        //then
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}