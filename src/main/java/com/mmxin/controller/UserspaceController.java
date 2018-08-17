package com.mmxin.controller;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户主页控制器
 * @author : mmxin
 * @className : UserspaceController
 * @date : 2018/8/17 10:18
 */
@Controller
@RequestMapping("/u")
public class UserspaceController {
    /**
     * 进入用户主页
     * @param username  客户名称
     * */
    @GetMapping("/{username}")
    public String userSpace(@PathVariable("username") String username){
        System.out.println("userName: " + username);
        return "/userspace/u";
    }

    /**
     * 查看用户的博客
     * @param keyword 关键字
     * @param order 排序方式
     * @param userName 用户名称
     * @param category  分类
     * */
    @GetMapping("/{username}/blogs")
    public String listBlogsByOrders(@PathVariable(value = "username")String userName,
                                    @RequestParam(value = "order",required = false,defaultValue = "new")String order,
                                    @RequestParam(value = "category",required = false)Long category,
                                    @RequestParam(value = "keyword",required = false)String keyword){
        if (category != null){
            System.out.println("category: " + category);
            System.out.println("selflink:" + "redirect:/u/" + userName + "/blogs?category="+category);
            return "/userspace/u";
        }else if (keyword != null && !keyword.isEmpty()){
            System.out.println("keyword: " + keyword);
            System.out.println("selflink:" + "redirect:/u/" + userName + "/blogs?keyword=" + keyword);
            return "/userspace/u";
        }
        System.out.println("order: " + order);
        System.out.println("selflink:" + "redirect:/u/" + userName + "/blogs?order=" + order);
        return "/userspace/u";
    }

    /**
     * 查询某个ID的博客
     * */
    @GetMapping("/{username}/blogs/{id}")
    public String listBlogByOrder(@PathVariable("id") long id){
        System.out.println("blogId : " + id);
        return "/userspace/blog";
    }

    /**
     * 编辑博客
     * */
    @GetMapping("/{username}/blogs/edit")
    public String editBlog(){
        return "/userspace/blogedit";
    }
}
