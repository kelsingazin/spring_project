package kz.bitlab.TestSpring.repositories;

import kz.bitlab.TestSpring.models.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Assylkhan
 * on 26.03.2020
 * @project TestSpring
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByActiveIsTrue();

    Optional<Post> findByIdAndActiveIsTrue(Long id);

}
