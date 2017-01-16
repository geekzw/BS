package com.gzw.service;

import com.gzw.dao.UserDao;
import com.gzw.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shuai on 17/1/16.
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public boolean insertUser(User user){
        return userDao.insertUser(user.getUsername(),user.getPassword(),user.getPhone()) == 0?false:true;
    }

    public String login(User user){
        int code = userDao.login(user.getUsername(),user.getPassword());
        return null;
    }
}
