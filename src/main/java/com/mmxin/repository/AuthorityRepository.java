package com.mmxin.repository;

import com.mmxin.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : mmxin
 * @className : AuthorityRepository
 * @date : 2018/8/24 11:35
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}

