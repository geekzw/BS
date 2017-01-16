package com.gzw.dao;

import com.gzw.domain.User;
import com.gzw.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by shuai on 17/1/16.
 */
@Repository
public class UserDao {

    @Autowired
    UserMapper userMapper;

    public int insertUser(String username,String password,String phone){
        return userMapper.insertUser(username,password,phone);
    }

    public int login(String username,String password){
        User user = userMapper.login(username,password);
        if(user == null){
            return 0;
        }else if(!user.getPassword().equals(password)){
            return 2;
        }else{
            return 1;
        }
    }
}
