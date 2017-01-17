package com.gzw.service;

import com.gzw.domain.response.BaseResponse;
import com.gzw.domain.User;

import javax.servlet.http.HttpSession;

/**
 * Created by gzw on 2017/1/17.
 */
public interface UserService {

    public boolean insertUser(User user);

    public BaseResponse<String> login(User user);

    public void insertSession(String sessionId,String session);
}
