package com.mmxin.controller;

import com.mmxin.domain.User;
import com.mmxin.service.UserService;
import com.mmxin.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * 用户主页控制器
 * @author : mmxin
 * @className : UserspaceController
 * @date : 2018/8/17 10:18
 */
@Controller
@RequestMapping("/u")
public class UserspaceController {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Value("$file.server.url")
    private String fileServerUrl ;

    // todo: 暂时不知道是干啥的，先留着，如果之后没用就删掉
    @GetMapping("/{username}")
    public String userSpace(@PathVariable("username") String username) {
        System.out.println("username" + username);
        return "u";
    }

    /**
     * 获取个人信息管理页面
     * */
    @GetMapping("/{username}/profile")
    @PreAuthorize("authentication.name.equals(#username)")
    public ModelAndView profile(@PathVariable("username") String username, Model model) {
        User user = (User)userDetailsService.loadUserByUsername(username);
        model.addAttribute("user", user);
        model.addAttribute("fileServerUrl",fileServerUrl);      //将文件服务器的地址返回给页面
        return new ModelAndView("/userspace/profile", "userModel", model);
    }

    /**
     * 保存个人设置
     * PreAuthorize 主要做的是一个权限控制管理，判断查看的是不是当前用户的信息
     * @param user
     * @param username
     */
    @PostMapping("/{username}/profile")
    @PreAuthorize("authentication.name.equals(#username)")
    public String saveProfile(@PathVariable("username") String username,User user) {
        User originalUser = userService.getUserById(user.getId());
        originalUser.setEmail(user.getEmail());
        originalUser.setName(user.getName());

        // 判断密码是否做了变更
        String rawPassword = originalUser.getPassword();
        PasswordEncoder  encoder = new BCryptPasswordEncoder();
        String encodePasswd = encoder.encode(user.getPassword());
        boolean isMatch = encoder.matches(rawPassword, encodePasswd);
        if (!isMatch) {
            originalUser.setEncodePassword(user.getPassword());
        }

        userService.saveUser(originalUser);
        return "redirect:/u/" + username + "/profile";
    }

    /**
     * 获取编辑头像的界面
     * @param username
     * @param user
     */
    @GetMapping("/{username}/avatar")
    @PreAuthorize("authentication.name.equals(#username)")
    public ResponseEntity<Response> avatar(@PathVariable("username") String username, @RequestBody User user){
        //用户提交图片之后返回一个资源服务器的链接，将链接存储到数据库
        String avatarUrl = user.getAvatar();
        //获取用户id，查找对应的用户，修改头像信息
        User originalUser = userService.getUserById(user.getId());
        originalUser.setAvatar(avatarUrl);
        userService.saveUser(originalUser);
        return ResponseEntity.ok().body(new Response(true,"处理成功", avatarUrl));
    }


    /**
     * 获取编辑头像的界面
     * @param username
     * @param user
     * @return
     */
    @PostMapping("/{username}/avatar")
    @PreAuthorize("authentication.name.equals(#username)")
    public ResponseEntity<Response> saveAvatar(@PathVariable("username") String username, User user) {
        String avatarUrl = user.getAvatar();

        User originalUser = userService.getUserById(user.getId());
        originalUser.setAvatar(avatarUrl);
        userService.saveUser(originalUser);

        return ResponseEntity.ok().body(new Response(true, "处理成功", avatarUrl));
    }


    @GetMapping("/{username}/blogs")
    public String listBlogsByOrder(@PathVariable("username") String username,
                                   @RequestParam(value="order",required=false,defaultValue="new") String order,
                                   @RequestParam(value="category",required=false ) Long category,
                                   @RequestParam(value="keyword",required=false ) String keyword) {

        if (category != null) {

            System.out.print("category:" +category );
            System.out.print("selflink:" + "redirect:/u/"+ username +"/blogs?category="+category);
            return "/u";

        } else if (keyword != null && keyword.isEmpty() == false) {

            System.out.print("keyword:" +keyword );
            System.out.print("selflink:" + "redirect:/u/"+ username +"/blogs?keyword="+keyword);
            return "/u";
        }

        System.out.print("order:" +order);
        System.out.print("selflink:" + "redirect:/u/"+ username +"/blogs?order="+order);
        return "/u";
    }

    @GetMapping("/{username}/blogs/{id}")
    public String listBlogsByOrder(@PathVariable("id") Long id) {

        System.out.print("blogId:" + id);
        return "/blog";
    }


    @GetMapping("/{username}/blogs/edit")
    public String editBlog() {

        return "/blogedit";
    }
}
