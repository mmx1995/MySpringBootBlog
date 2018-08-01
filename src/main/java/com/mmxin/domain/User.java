package com.mmxin.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 用户实体
 * @author mmx
 * @date 2018-06-04
 * */
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 5369565050437493701L;
    /**
     * 用户实体类唯一标识
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    /**
     * 用户姓名
     * */
    private String name ;

    /**
     * 用户邮箱
     * */
    private String email ;

    /**
     * 空构造函数
     * */
    public User() {
    }

    /**
     * 带参构造函数
     * */
    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
