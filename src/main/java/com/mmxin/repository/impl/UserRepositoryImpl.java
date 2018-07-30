package com.mmxin.repository.impl;

import com.mmxin.domain.User;
import com.mmxin.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static AtomicLong conuter = new AtomicLong();
    /**
     * 模拟数据库
     * */
    private final ConcurrentMap<Long,User> userMap = new ConcurrentHashMap<>();


    /**
     * 新增一个用户
     * */
    @Override
    public User savaOrUpdateUser(User user) {
        Long id = user.getId();
        if(id == null){
            id = conuter.incrementAndGet();
            user.setId(id);
        }
        this.userMap.put(id,user);
        return user;
    }

    /**
     * 删除一个用户
     * */
    @Override
    public void deleteUser(Long id) {
        this.userMap.remove(id);
    }

    /**
     * 返回一个用户
     * */
    @Override
    public User getUserById(Long id) {
        return this.userMap.get(id);
    }

    /**
     * 返回用户列表
     * */
    @Override
    public List<User> listUsers() {
        return new ArrayList<>(this.userMap.values());
    }
}
