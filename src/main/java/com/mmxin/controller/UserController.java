package com.mmxin.controller;

import com.mmxin.domain.User;
import com.mmxin.repository.UserRepository;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
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
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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

    /**
     * 获取用户列表页面
     * */
    @GetMapping
    public ModelAndView listUsers(Model model){
        model.addAttribute("userList",userRepository.findAll());
        model.addAttribute("title","用户管理");
        log.info("now page : users");
        return new ModelAndView("users/list","userModel",model);
    }

    /**
     * 查询用户详情页面
     * */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id")Long id, Model model){
        Optional<User> optional  = userRepository.findById(id);
        User user = optional.get();
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        log.info(user.toString());
        return new ModelAndView("users/view","userModel",model);
    }

    /**
     * 创建用户页面
     * */
    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","userModel",model);
    }


    /**
     * 编辑用户信息页面
     * */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user, Model model){
        user  = userRepository.save(user);
        return new ModelAndView("redirect:/users","userModel",model);
    }

    /**
     * 删除用户页面
     * */
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
