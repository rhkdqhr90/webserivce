package dudu.webservice.web;

import dudu.webservice.service.posts.PostsService;
import dudu.webservice.web.dto.PostsResponseDto;
import dudu.webservice.web.dto.PostsSaveRequestDto;
import dudu.webservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@RequestBody PostsUpdateRequestDto updateDto, @PathVariable("id") Long id) {
        return postsService.update(id, updateDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable("id") Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        postsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

