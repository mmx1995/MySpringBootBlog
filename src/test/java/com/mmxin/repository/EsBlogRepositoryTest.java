package com.mmxin.repository;

import com.mmxin.domain.EsBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 接口测试
 * */

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {

    @Autowired
    private EsBlogRepository esBlogRepository ;

    //@Before
    public void initRepositoryDate(){
        //清除所有数据
        esBlogRepository.deleteAll();
        //添加新的数据
        esBlogRepository.save(new EsBlog("行宫","元稹","寥落古行宫，宫花寂寞红。\n" +
                "白头宫女在，闲坐说玄宗。"));
        esBlogRepository.save(new EsBlog("相思","王维","红豆生南国，春来发几枝。\n" +
                "愿君多采撷，此物最相思。"));
        esBlogRepository.save(new EsBlog("鹿柴","王维","空山不见人，但闻人语响。\n" +
                "返景入深林，复照青苔上。"));
    }

    @Test
    public void findDistinctByTitleContainingOrSummaryContaining(){
        System.out.println("-----------------1-----------------");
        Pageable pageable = new PageRequest(0,10);
        Page<EsBlog>  page= esBlogRepository.findDistinctByTitleContainingOrSummaryContaining("思","元",pageable);
        for (EsBlog esBlog : page){
            System.out.println(esBlog.toString());
        }

        System.out.println("-----------------2-----------------");
        Pageable pageable1 = new PageRequest(0,1);
        Page<EsBlog>  page1= esBlogRepository.findDistinctByTitleContainingOrSummaryContaining("思","元",pageable1);
        for (EsBlog esBlog : page1){
            System.out.println(esBlog.toString());
        }

        System.out.println("-----------------3-----------------");
        Pageable pageable2 = new PageRequest(1,1);
        Page<EsBlog>  page2= esBlogRepository.findDistinctByTitleContainingOrSummaryContaining("思","元",pageable2);
        for (EsBlog esBlog : page2){
            System.out.println(esBlog.toString());
        }

        System.out.println("-----------------4-----------------");
        Pageable pageable3 = new PageRequest(0,2);
        Page<EsBlog>  page3= esBlogRepository.findDistinctByTitleContainingOrSummaryContaining("思","元",pageable3);
        for (EsBlog esBlog : page3){
            System.out.println(esBlog.toString());
        }

        System.out.println("-----------------5-----------------");
        Pageable pageable4 = new PageRequest(1,2);
        Page<EsBlog>  page4= esBlogRepository.findDistinctByTitleContainingOrSummaryContaining("思","元",pageable4);
        for (EsBlog esBlog : page4){
            System.out.println(esBlog.toString());
        }
    }
}
