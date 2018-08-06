package com.mmxin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 18636
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {
    @RequestMapping(value = "hello")
    public String hello(){
        return "index";
    }
}
