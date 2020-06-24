package kz.bitlab.TestSpring.controllers;

import kz.bitlab.TestSpring.models.entities.Post;
import kz.bitlab.TestSpring.models.requests.AddPostRequest;
import kz.bitlab.TestSpring.models.requests.UpdatePostRequest;
import kz.bitlab.TestSpring.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Assylkhan
 * on 28.03.2020
 * @project TestSpring
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    @PostMapping
    public Post addPostModel(@ModelAttribute AddPostRequest request, Authentication authentication) {
        String username = authentication.getName();
        return postService.addPost(request.getTitle(), request.getDescription(), username);
    }

    @GetMapping("{id}")
    public Post getById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @GetMapping
    public List<Post> findAll() {
        return postService.findAll();
    }

    @DeleteMapping("{id}")
    public Map deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return Collections.singletonMap("message", "deleted");
    }

    //Another variant of deleting
//    @DeleteMapping("{id}")
//    public void deletePost(@PathVariable Long id){
//        postService.deletePost(id);
//    }

    @PutMapping("{id}")
    public Post updatePost(@RequestBody @Valid UpdatePostRequest request, @PathVariable Long id){
        return this.postService.update(id, request.getTitle(), request.getDescription());
    }
}
