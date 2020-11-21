package com.bzhi2.monster.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/11/8 18:22
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfigure extends WebSecurityConfigurerAdapter {
    /**
     * lombok会自动针对final类型的变量创建有参构造函数，这样可以注入进入
     */
    private final CorsFilter corsFilter;
    /**
     * 加载数据库的用户和权限信息
     * 设置password encoder
     * @return
     */
//    @Override
//    protected UserDetailsService userDetailsService() {
//        return super.userDetailsService();
//    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        //todo:需要给密码加密
        //return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }
    /**
     * 配置要拦截的url路径
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // 禁用 CSRF
                .csrf().disable()
                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
                // 授权异常
                .exceptionHandling()
                // 防止iframe 造成跨域
                .and()
                .headers()
                .frameOptions()
                .disable()
                // 不创建会话
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 静态资源等等
                .antMatchers(
                        HttpMethod.GET,
                    "/auth/queryUserList/**"
                ).permitAll();
    }
}
