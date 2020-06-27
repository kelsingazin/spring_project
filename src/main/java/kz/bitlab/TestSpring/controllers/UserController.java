package kz.bitlab.TestSpring.controllers;

import kz.bitlab.TestSpring.models.entities.User;
import kz.bitlab.TestSpring.models.reponses.SuccessResponse;
import kz.bitlab.TestSpring.models.requests.UserRegisterRequest;
import kz.bitlab.TestSpring.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @PostMapping
    public User registerUser(@Valid @RequestBody UserRegisterRequest request) {
        return this.userService.registerUser(request.getUsername(), request.getPassword());
    }

    @GetMapping
    public List<User> loadAll() {
        return this.userService.findAll();
    }

    @DeleteMapping("{id}")
    public SuccessResponse updateUser(@PathVariable Long id) {
        this.userService.delete(id);
        return SuccessResponse.builder().message("user with id " + id + " deleted").build();
    }

    @GetMapping("/check/{username}")
    public Map checkUsername(@PathVariable String username){
        User user = this.userService.findByUsername(username);
        return Collections.singletonMap("exists", Objects.nonNull(user));
    }

}
