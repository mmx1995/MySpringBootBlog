package com.mmxin.controller;

import com.mmxin.domain.User;
import com.mmxin.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
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

    Log log = LogFactory.getLog(UserController.class);


    /**
     * 查询所有用户
     * @param model
     * */
    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList",userRepository.listUsers());
        model.addAttribute("title","用户管理");
        log.info("now page : users");
        return new ModelAndView("users/list","userModel",model);
    }

    /**
     * 查询单个用户
     * 需要注意的是id必须用大括号括起来
     * @param model
     * @param id
     * */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id")Long id, Model model){
        User user  = userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        log.info(user.toString());
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
     * 表单提交完成，重定向到主页面
     * @param user
     * */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user, Model model){
        user  = userRepository.savaOrUpdateUser(user);
        return new ModelAndView("redirect:/users","userModel",model);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id")Long id,Model model){
        userRepository.deleteUser(id);
        model.addAttribute("title","用户列表");
        model.addAttribute("userList",userRepository.listUsers());
        return new ModelAndView("redirect/users","userModel",model);
    }
}
