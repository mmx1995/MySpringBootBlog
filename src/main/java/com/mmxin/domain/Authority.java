package com.mmxin.domain;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 * 权限
 * @author : mmxin
 * @className : Authority
 * @date : 2018/8/17 17:35
 */
public class Authority implements GrantedAuthority,Serializable {
    /*序列化编号*/
    private static final long serialVersionUID = 6926121329430637521L;

    @Override
    public String getAuthority() {
        return null;
    }
}
