package kz.bitlab.TestSpring.controllers;

import kz.bitlab.TestSpring.models.entities.User;
import kz.bitlab.TestSpring.models.reponses.SuccessResponse;
import kz.bitlab.TestSpring.models.requests.UserRegisterRequest;
import kz.bitlab.TestSpring.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Assylkhan
 * on 26.03.2020
 * @project TestSpring
 */
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

}
