package com.gzw.controllers.appcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gzw on 2017/1/17.
 */
@Controller
public class AppIndexController {

    @RequestMapping("/app/admin/index")
    public String index(){
        return "/app/admin/index";
    }
}
