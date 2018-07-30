package com.mmxin.controller;

import com.mmxin.domain.User;
import com.mmxin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * User 控制器
 * @author mmx
 * @date 2018/07/30
 * */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository ;


    /**
     * 查询所有用户
     * @param model
     * */
    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList",userRepository.listUsers());
        model.addAttribute("title","用户管理");
        System.out.println("list");
        return new ModelAndView("users/list","userModel",model);
    }

    /**
     * 查询单个用户
     * @param model
     * @param id
     * */
    @GetMapping("id")
    public ModelAndView view(@PathVariable("id")Long id, Model model){
        User user  = userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/view","userModel",model);
    }


    /**
     * 获取创建表单页面
     * @param model
     * */
    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","userModel",model);
    }

    /**
     * @param user
     * */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user, Model model){
        user  = userRepository.savaOrUpdateUser(user);
        return new ModelAndView("users/form","userModel",model);
    }

}
