package com.mmxin.service.impl;

import com.mmxin.domain.Authority;
import com.mmxin.repository.AuthorityRepository;
import com.mmxin.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : mmxin
 * @className : AuthorityServiceImpl
 * @date : 2018/8/24 11:37
 */
@Service
public class AuthorityServiceImpl  implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Authority getAuthorityById(Long id) {
        return authorityRepository.getOne(id);
    }

}
