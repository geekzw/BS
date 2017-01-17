package com.gzw.controllers.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gzw on 2017/1/17.
 */
@Controller
public class WebIndexController {

    @RequestMapping("/web/admin/index")
    public String index(){
        return "/web/admin/index";
    }
}
