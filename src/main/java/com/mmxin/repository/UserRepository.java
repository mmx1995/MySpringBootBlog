package com.mmxin.repository;

import com.mmxin.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户接口
 * @author mmx
 * @date 2018年6月4日
 * */
public interface UserRepository  extends JpaRepository<User,Long> {

    /*
    * 根据用户姓名分页查询用户列表
    * */
    Page<User> findByNameLike(String name, Pageable pageable);

    /*
    * 根据用户账号查询用户
    * */
    User findByUserName(String userName);

    UserDetails loadUserByUserName();

}
