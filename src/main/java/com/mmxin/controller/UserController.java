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

import java.util.Optional;

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

    @GetMapping
    public ModelAndView listUsers(Model model){
        model.addAttribute("userList",userRepository.findAll());
        model.addAttribute("title","用户管理");
        log.info("now page : users");
        return new ModelAndView("users/list","userModel",model);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id")Long id, Model model){
        Optional<User> optional  = userRepository.findById(id);
        User user = optional.get();
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        log.info(user.toString());
        return new ModelAndView("users/view","userModel",model);
    }

    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","userModel",model);
    }

    @PostMapping
    public ModelAndView saveOrUpdateUser(User user, Model model){
        user  = userRepository.save(user);
        return new ModelAndView("redirect:/users","userModel",model);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id")Long id,Model model){
        userRepository.deleteById(id);
        return new ModelAndView("redirect:/users","userModel",model);
    }

    /**
     * 修改用户信息
     * */
    @GetMapping("modify/{id}")
    public ModelAndView modifyUser(@PathVariable("id")Long id, Model model){
        model.addAttribute("title","用户详情");
        model.addAttribute("user",userRepository.findById(id).get());
        return new ModelAndView("/users/form","userModel", model);
    }
}
