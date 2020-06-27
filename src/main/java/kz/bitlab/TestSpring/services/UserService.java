package kz.bitlab.TestSpring.services;

import kz.bitlab.TestSpring.models.entities.User;
import kz.bitlab.TestSpring.models.exceptions.SystemServiceException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {

    User registerUser(String username, String password) throws SystemServiceException;

    List<User> findAll();

    User findById(Long id);

    User findByUsername(String username);

    User update(User user) throws SystemServiceException;

    void delete(User user) throws SystemServiceException;

    void delete(Long id) throws SystemServiceException;
}
