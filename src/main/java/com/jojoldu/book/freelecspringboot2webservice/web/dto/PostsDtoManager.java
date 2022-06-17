package com.jojoldu.book.freelecspringboot2webservice.web.dto;

import com.jojoldu.book.freelecspringboot2webservice.doamin.post.Posts;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostsDtoManager {
    protected Long id;
    protected  String title;
    protected  String content;
    protected String author;

    public Posts toEntity(){
        return Posts.builder()
                .title(this.title)
                .content(this.content)
                .author(this.author).build();
    }

    public Posts toEntity2(){
        return new Posts(this.title, this.content, this.author);
    }
}
