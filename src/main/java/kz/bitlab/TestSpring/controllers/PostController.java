package kz.bitlab.TestSpring.controllers;

import kz.bitlab.TestSpring.models.entities.Post;
import kz.bitlab.TestSpring.models.requests.AddPostRequest;
import kz.bitlab.TestSpring.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public Post addPost(@RequestParam String title,
                        @RequestParam String description,
                        @RequestParam Long userId) {
        return postService.addPost(title, description, userId);
    }

    @PostMapping("/model")
    public Post addPostModel(@ModelAttribute AddPostRequest request) {
        return postService.addPost(request.getTitle(), request.getDescription(), request.getUserId());
    }

}
