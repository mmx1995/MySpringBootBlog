package com.mmxin.service;

import com.mmxin.domain.Authority;

import java.util.Optional;

/**
 * @author : mmxin
 * @className : AuthorityService
 * @date : 2018/8/24 11:36
 */
public interface AuthorityService {

    /**
     * 根据id获取 Authority
     * @param id
     * @return
     */
    Authority getAuthorityById(Long id);

}
