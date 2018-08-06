package com.mmxin.repository;

import com.mmxin.domain.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * EsBlog Repository 接口
 * @author mmx
 *
 * */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog,String> {
    /**
     * 根据标题和内容进行分页查询（去重）
     * @param title 标题
     * @param summary 摘要
     *
     * */
    Page<EsBlog> findDistinctByTitleContainingOrSummaryContaining(String title,String summary,Pageable pageable);
}
