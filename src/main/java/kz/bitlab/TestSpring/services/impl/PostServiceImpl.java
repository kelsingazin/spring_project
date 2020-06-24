package kz.bitlab.TestSpring.services.impl;

import kz.bitlab.TestSpring.models.entities.Post;
import kz.bitlab.TestSpring.models.entities.User;
import kz.bitlab.TestSpring.models.errors.ErrorCode;
import kz.bitlab.TestSpring.models.exceptions.SystemServiceException;
import kz.bitlab.TestSpring.repositories.PostRepository;
import kz.bitlab.TestSpring.repositories.UserRepository;
import kz.bitlab.TestSpring.services.PostService;
import kz.bitlab.TestSpring.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Assylkhan
 * on 28.03.2020
 * @project TestSpring
 */
@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private UserService userService;
    private PostRepository postRepository;

    @Override
    public Post addPost(String title, String description, String username) throws SystemServiceException {
        User user = this.userService.findByUsername(username);

        if (Objects.nonNull(user)) {
            Post post = Post.builder()
                    .active(true)
                    .author(user)
                    .description(description)
                    .title(title)
                    .build();
            return postRepository.save(post);
        }

        throw SystemServiceException.builder()
                .message("no user with such id")
                .errorCode(ErrorCode.ENTITY_NOT_FOUND)
                .build();
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAllByActiveIsTrue();
    }

    @Override
    public void deletePost(Long id) throws SystemServiceException {
        Post post = findById(id);
        post.setActive(false);
        update(post);
    }

    @Override
    public Post findById(Long id) throws SystemServiceException {
        return postRepository.findByIdAndActiveIsTrue(id).orElseThrow(
                () -> SystemServiceException
                        .builder()
                        .message("No post with such id")
                        .errorCode(ErrorCode.ENTITY_NOT_FOUND)
                        .build()
        );
    }

    @Override
    public Post update(Long id, String title, String description) throws SystemServiceException {
        Post post = this.findById(id);
        post.setTitle(title);
        post.setDescription(description);
        return postRepository.save(post);

    }

    @Override
    public Post update(Post post) throws SystemServiceException {
        if (Objects.nonNull(post.getId())) {
            return postRepository.save(post);
        }

        throw SystemServiceException.builder()
                .message("This post is still noT persisted")
                .errorCode(ErrorCode.ENTITY_NOT_FOUND)
                .build();
    }
}
