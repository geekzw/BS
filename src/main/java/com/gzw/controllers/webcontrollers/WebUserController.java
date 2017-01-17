package com.gzw.controllers.webcontrollers;

import com.alibaba.fastjson.JSON;
import com.gzw.domain.response.BaseResponse;
import com.gzw.domain.User;
import com.gzw.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by shuai on 17/1/16.
 */
@Controller
public class WebUserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/web/register")
    public String register(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @RequestMapping("/web/login")
    public String login(Model model){
        model.addAttribute("user",new User());
        return "login";
    }

    @RequestMapping(value = "/web/doLogin", method = RequestMethod.POST)
    public String doLogin(User user){
        return JSON.toJSONString(userService.login(user));
    }

    @RequestMapping(value = "/web/doRegister", method = RequestMethod.POST)
    public String doRegister(User user){
        BaseResponse<User> response = new BaseResponse<>();
        if(userService.insertUser(user)){
            response.resultCode = 1;
            response.codeDescription = "注册成功";
        }else{
            response.resultCode = 0;
            response.codeDescription = "注册失败";
        }

        return JSON.toJSONString(response);
    }
}
