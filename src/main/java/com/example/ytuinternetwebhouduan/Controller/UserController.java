package com.example.ytuinternetwebhouduan.Controller;

import com.example.ytuinternetwebhouduan.Service.UserService;
import com.example.ytuinternetwebhouduan.entity.User;
import com.example.ytuinternetwebhouduan.util.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public boolean addUser(@RequestBody User user) {

        return userService.addUser(user);
    }

    @GetMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            return "用户不存在";
        } else if (!user.getPassword().equals(password)) {
            return "密码错误";
        } else {
            TokenService tokenService = new TokenService();
            String token=tokenService.generateToken(username,password);
            return token;
        }
    }
    @DeleteMapping("/{uid}")
    public ResponseEntity<Void> deleteUser(@PathVariable int uid) {
        userService.deleteUserById(uid);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{uid}")
    public ResponseEntity<User> updateUser(@PathVariable int uid, @RequestBody User user) {
        user.setUid(uid);
        userService.updateUser(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{uid}")
    public ResponseEntity<User> getUser(@PathVariable int uid) {
        User user = userService.getUserById(uid);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}

