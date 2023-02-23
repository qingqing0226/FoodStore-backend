package se.salt.FoodStore.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    ResponseEntity getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    ResponseEntity createUser(@RequestBody User user) {
        User created = userService.saveUser(user);
        return ResponseEntity.created(URI.create("/api/users/" + created.getId())).body(created);
    }

    @GetMapping("/{name}/{email}")
    ResponseEntity getByEmail(@PathVariable String name, @PathVariable String email) {
        try {
            return ResponseEntity.ok(userService.getByEmail(email));
        } catch (Exception e) {
            User newUser = userService.saveUser(new User(name.replace('+', ' '), email));
            return ResponseEntity.ok(newUser);
        }
    }

    @PutMapping("/{id}")
    ResponseEntity updateUser(@PathVariable long id, @RequestBody User updateUser) {
        try {
            User user = userService.getById(id);
            if(user.getId() == updateUser.getId()) {
                return ResponseEntity.ok(userService.saveUser(updateUser));
            } else {
                throw new ResponseStatusException(NOT_FOUND, "ID mismatch");
            }
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(NOT_FOUND, e.getMessage());
        }
    }
}
