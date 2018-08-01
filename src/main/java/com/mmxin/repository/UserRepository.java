package com.mmxin.repository;

import com.mmxin.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 用户接口
 * @author mmx
 * @date 2018年6月4日
 * */
public interface UserRepository  extends CrudRepository<User,Long> {
}
