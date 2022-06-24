package com.jojoldu.book.freelecspringboot2webservice.web;

import com.jojoldu.book.freelecspringboot2webservice.doamin.post.PostsRepository;
import com.jojoldu.book.freelecspringboot2webservice.service.posts.PostsService;
import com.jojoldu.book.freelecspringboot2webservice.web.dto.PostsListResponseDto;
import com.jojoldu.book.freelecspringboot2webservice.web.dto.PostsResponseDto;
import com.jojoldu.book.freelecspringboot2webservice.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.freelecspringboot2webservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private  final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Map save(@RequestBody PostsSaveRequestDto requestDto){
        Long id = postsService.save(requestDto);
        Map map = new ConcurrentHashMap();
        map.put("id", id);
        return map;
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    /*@GetMapping("/api/v1/posts")
    public List<PostsListResponseDto> index2(Model model){
        return postsService.findAllDesc();
    }*/
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;

    }
}
