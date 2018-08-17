package com.mmxin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 后台管理控制器
 * @author : mmxin
 * @className : AdminController
 * @date : 2018/8/17 10:17
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    /**
     * 获取后台管理的主页面
     * */
    @GetMapping
    public ModelAndView listUsers(Model model){
        System.out.println("Here is in admins");
        return new ModelAndView("/admins/index","menuList",model);
    }
}
