package com.mmxin.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author : mmxin
 * @className : SpringSecurityConfigure
 * @date : 2018/8/15 11:30
 * 安全配置类
 * 重写configure 方法
 */
@EnableWebSecurity
public class SpringSecurityConfigure extends WebSecurityConfigurerAdapter {
    /**
     * 自定义配置
     * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**","/js/**","/fonts/**","/index").permitAll()  //都可以访问
                .antMatchers("/users/**").hasRole("ADMIN")  //需要相应的访问权限
                .and()
                .formLogin()   //基于from表单登陆验证
                .loginPage("/login").failureUrl("/login-error");  //自定义登陆页面
    }

    /**
     * 认证信息管理
     * @param auth
     * @throws Exception
     * */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("mmxin")
                .password(new BCryptPasswordEncoder().encode("mmxin"))
                .roles("ADMIN");
    }
}
