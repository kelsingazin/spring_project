package kz.bitlab.TestSpring.services.impl;

import kz.bitlab.TestSpring.models.entities.Role;
import kz.bitlab.TestSpring.models.entities.User;
import kz.bitlab.TestSpring.models.errors.ErrorCode;
import kz.bitlab.TestSpring.models.exceptions.SystemServiceException;
import kz.bitlab.TestSpring.repositories.RoleRepository;
import kz.bitlab.TestSpring.repositories.UserRepository;
import kz.bitlab.TestSpring.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User registerUser(String username, String password) throws SystemServiceException {

        if (userRepository.findUserByUsernameAndActiveIsTrue(username).isPresent()) {
            throw SystemServiceException.builder()
                    .errorCode(ErrorCode.USERNAME_ALREADY_EXISTS)
                    .message("User with such username already exists")
                    .build();
        }

        Optional<Role> userRole = this.roleRepository.findById(Role.ROLE_USER);

        if (userRole.isPresent()) {
            Set<Role> set = new HashSet<Role>();
            set.add(userRole.get());
//            Stream.of(userRole.get()).collect(Collectors.toSet())
            return this.userRepository.save(User.builder()
                    .password(bCryptPasswordEncoder.encode(password))
                    .roles(set)
                    .username(username)
                    .build());
        }
        throw SystemServiceException.builder()
                .errorCode(ErrorCode.ENTITY_NOT_FOUND)
                .message("Role with role user not found")
                .build();
//        throw new SystemServiceException("Role with role user not found", ErrorCode.ENTITY_NOT_FOUND);
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAllByActiveIsTrue();
    }

    @Override
    public User update(User user) throws SystemServiceException {
        if (Objects.nonNull(user.getId())) {
            return userRepository.save(user);
        }

        throw SystemServiceException.builder()
                .message("entity not found")
                .errorCode(ErrorCode.ENTITY_NOT_FOUND)
                .build();

    }

    @Override
    public void delete(User user) throws SystemServiceException {
        user.setActive(false);
        update(user);
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findByIdAndActiveIsTrue(id).orElseThrow(() ->
                SystemServiceException.builder()
                        .errorCode(ErrorCode.ENTITY_NOT_FOUND)
                        .message("User with  id " + id + " not found")
                        .build()
        );
    }

    @Override
    public void delete(Long id) throws SystemServiceException {
        User user = findById(id);
        delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOpt = userRepository.findUserByUsernameAndActiveIsTrue(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(), new ArrayList<>());
        } else {
            return null;
        }
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findUserByUsernameAndActiveIsTrue(username).orElse(null);
    }
}
