package com.example.internetwork.service.impl;



import com.example.internetwork.entity.User;
import com.example.internetwork.mapper.UserMapper;
import com.example.internetwork.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl  implements UserService {
    @Resource
    private UserMapper userMapper;

    public boolean addUser(User user) {
        if(userMapper.getUserByUsername(user.getUsername())!=null)
            return false;
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

    public PageInfo<User> getAllUsers(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList=userMapper.getAllUsers();
        return new PageInfo<>(userList);
    }

    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

}
