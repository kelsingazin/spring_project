package kz.bitlab.TestSpring.services.impl;

import kz.bitlab.TestSpring.models.entities.Post;
import kz.bitlab.TestSpring.models.entities.User;
import kz.bitlab.TestSpring.models.errors.ErrorCode;
import kz.bitlab.TestSpring.models.exceptions.SystemServiceException;
import kz.bitlab.TestSpring.repositories.PostRepository;
import kz.bitlab.TestSpring.repositories.UserRepository;
import kz.bitlab.TestSpring.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Assylkhan
 * on 28.03.2020
 * @project TestSpring
 */
@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private UserRepository userRepository;
    private PostRepository postRepository;

    @Override
    public Post addPost(String title, String description, Long userId) throws SystemServiceException {
        Optional<User> userOpt = userRepository.findByIdAndActiveIsTrue(userId);
        if (userOpt.isPresent()) {
            Post post = Post.builder()
                    .active(true)
                    .author(userOpt.get())
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
}
