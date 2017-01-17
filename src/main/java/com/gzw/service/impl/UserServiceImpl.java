package com.gzw.service.impl;

import com.alibaba.fastjson.JSON;
import com.gzw.common.CodeEnum;
import com.gzw.common.ResultCode;
import com.gzw.domain.Session;
import com.gzw.domain.response.BaseResponse;
import com.gzw.domain.User;
import com.gzw.mapper.UserMapper;
import com.gzw.service.UserService;
import com.gzw.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by shuai on 17/1/16.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean insertUser(User user){
        return userMapper.insertUser(user.getUsername(),user.getPassword(),user.getPhone()) == 0?false:true;
    }

    @Override
    public BaseResponse<String> login(User user){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        User us = userMapper.login(user.getUsername(),user.getPassword());
        CodeEnum codeEnum;
        if(us == null){
            codeEnum = CodeEnum.getCodeEnum(ResultCode.NO_USER);
            baseResponse.resultCode = codeEnum.getCode();
            baseResponse.codeDescription = codeEnum.getDescription();
        }else if(!us.getPassword().equals(user.getPassword())){
            codeEnum = CodeEnum.getCodeEnum(ResultCode.PASSWORD_ERROR);
            baseResponse.resultCode = codeEnum.getCode();
            baseResponse.codeDescription = codeEnum.getDescription();
        }else{
            codeEnum = CodeEnum.getCodeEnum(ResultCode.LOGIN_SUCCESS);
            baseResponse.resultCode = codeEnum.getCode();
            baseResponse.codeDescription = codeEnum.getDescription();
            long time = System.currentTimeMillis();
            String sessionId = MD5Util.getMD5(time+user.getUsername());
            Session session = new Session();
            session.setAttr("username",user.getUsername());
            String se = JSON.toJSONString(session);
            insertSession(sessionId, se);
            baseResponse.result = sessionId;
        }
        return baseResponse;
    }

    @Override
    public void insertSession(String sessionId, String session) {
        userMapper.insertSession(sessionId,session);
    }
}
