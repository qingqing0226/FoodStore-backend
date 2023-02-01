package se.salt.FoodStore.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.NoSuchElementException;

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
        User created = userService.createUser(user);
        return ResponseEntity.created(URI.create("/api/users/" + created.getId())).body(created);
    }

    @GetMapping("/{name}/{email}")
    ResponseEntity getByEmail(@PathVariable String name, @PathVariable String email) {
        try {
            return ResponseEntity.ok(userService.getByEmail(email));
        } catch (Exception e) {
            User newUser = userService.createUser(new User(name.replace('+', ' '), email));
            System.out.println("--- New User---");
            System.out.println(newUser.getName() + " " + newUser.getEmail());
            return ResponseEntity.ok(newUser);
        }
    }
}
