package kz.bitlab.TestSpring.repositories;

import kz.bitlab.TestSpring.models.entities.User;
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
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByActiveIsTrue();

    Optional<User> findUserByUsernameAndActiveIsTrue(String username);

    Optional<User> findByIdAndActiveIsTrue(Long id);


}
