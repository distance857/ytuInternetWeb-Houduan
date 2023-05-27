package com.example.ytuinternetwebhouduan.Service;

import com.example.ytuinternetwebhouduan.entity.User;
import com.example.ytuinternetwebhouduan.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    public int deleteUserById(int uid) {
        return userMapper.deleteUserById(uid);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public User getUserById(int uid) {
        return userMapper.getUserById(uid);
    }

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }
}
