package com.zjm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/*基于内存的认证配置*/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder(10);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("root").password("123").roles("ADMIN","DBA")
                .and()
                .withUser("admin").password("123").roles("ADMIN","USER")
                .and()
                .withUser("zjm").password("123").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**")
                .hasRole("ADMIN") //用户访问/admin/**模式下的URL必须具备ADMIN的角色
                .antMatchers("/user/**")
                .access("hasAnyRole('ADMIN','USER')") //用户访问/user/**模式下的URL必须具备ADMIN或者USER的角色
                .antMatchers("/db/**")
                .access("hasRole('ADMIN') and hasRole('DBA')") //用户访问/db/**模式下的URL必须具备ADMIN和DBA的角色
                .anyRequest()
                .authenticated()//表示出了前面定义的RUL模式外，用户访问其他的url都必须认证后访问（登录后访问）
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .permitAll()//表示和登录相关的接口不需要认证即可访问
                .and()
                .csrf()
                .disable();//关闭csrf
    }
}
