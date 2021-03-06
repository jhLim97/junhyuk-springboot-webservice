package com.springboot.study.web;

import com.springboot.study.service.posts.PostsService;
import com.springboot.study.web.dto.PostsListResponseDto;
import com.springboot.study.web.dto.PostsResponseDto;
import com.springboot.study.web.dto.PostsSaveRequestDto;
import com.springboot.study.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // 선언된 모든 final 필드가 포함된 생성자를 생성(final 이 없는 필드는 생성자에 미포함)
@RestController // JSON 을 반환하는 컨트롤러로...
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts") // 등록
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}") // 수정
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}") // 삭제
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}") // 조회
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }

    @GetMapping("/api/v1/posts/list") // 책에 없지만 깃허브 보고 추가
    public List<PostsListResponseDto> findAll() {
        return postsService.findAllDesc();
    }

}
