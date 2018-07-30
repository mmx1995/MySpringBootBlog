package com.mmxin.repository;

import com.mmxin.domain.User;

import java.util.List;

/**
 * 用户接口
 * @author mmx
 * @date 2018年6月4日
 * */
public interface UserRepository {

    /**
     * 创建或者更新用户
     * @param user
     * @return User
     * */
    User savaOrUpdateUser(User user);

    /**
     * 删除客户
     * @param id
     * */
    void deleteUser(Long id);

    /**
     * 根据Id查询客户
     * @param id
     * @return User
     * */
    User getUserById(Long id);

    /**
     * 获取用户列表
     * */
    List<User>  listUsers();

}
