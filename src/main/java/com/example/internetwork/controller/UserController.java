package com.example.internetwork.controller;


import com.example.internetwork.entity.User;
import com.example.internetwork.service.UserService;
import com.example.internetwork.utils.TokenUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.token.TokenService;
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

//    public static String token_tmp;
    @GetMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        User user = userService.getUserByUsername(username);
        System.out.println(user);
        if (user == null) {
            return "用户不存在";
        } else if (!user.getPassword().equals(password)) {
            return "密码错误";
        } else {
            TokenUtils tokenService = new TokenUtils();
            String token = tokenService.genToken(user);
//            token_tmp = token;
//            System.out.println(token);
//            System.out.println("111");
            user.setToken(token);
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

    @GetMapping("/all/{pageNum}/{pageSize}")
    public ResponseEntity<PageInfo<User>> getAllUsers(@PathVariable(value = "pageSize") int pageSize,
                                                  @PathVariable(value = "pageNum") int pageNum) {
        PageInfo<User> users = userService.getAllUsers(pageNum,pageSize);
        return ResponseEntity.ok(users);
    }
}
