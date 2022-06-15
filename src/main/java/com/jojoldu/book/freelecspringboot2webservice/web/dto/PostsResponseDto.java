package com.jojoldu.book.freelecspringboot2webservice.web.dto;

import com.jojoldu.book.freelecspringboot2webservice.doamin.post.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts posts){
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.author = posts.getAuthor();
    }
}
