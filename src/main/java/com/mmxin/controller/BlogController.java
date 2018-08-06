package com.mmxin.controller;


import com.mmxin.domain.EsBlog;
import com.mmxin.repository.EsBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 18636
 */
@RestController
@RequestMapping("blog")
public class BlogController {

    @Autowired
    EsBlogRepository esBlogRepository ;

    @GetMapping
    public List<EsBlog> list(@RequestParam(value = "title")String title,
                             @RequestParam(value = "summary")String summary,
                             @RequestParam(value = "content")String content,
                             @RequestParam(value = "pageIndex", defaultValue = "0") int pageIndex,
                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        System.out.println("title : " + title);
        System.out.println("summary : " + summary);
        System.out.println("content : " + content);
        System.out.println("pageIndex : " + pageIndex);
        System.out.println("pageSize : " + pageSize);
        List<EsBlog> list = new ArrayList<>();
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<EsBlog> page = esBlogRepository.findDistinctByTitleContainingOrSummaryContaining(title,summary,pageable);
        for (EsBlog esBlog : page){
            list.add(esBlog);
        }
        return list;
    }
}
