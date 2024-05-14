package com.sbs.sbb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration  // @ : 어너테이션
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .formLogin((formLogin) -> formLogin
                        // GET
                        // 시큐리티에게 우리가 만든 로그인 페이지 url을 알려준다
                        // 만약 이걸 하지 않으면 기본적으로 로그인 페이지 url은 "/login" 이다.
                        .loginPage("/user/login")
                        .defaultSuccessUrl("/"))
                .logout(
                        logout -> logout
                                .logoutUrl("/user/logout")
                                .logoutSuccessUrl("/")
                                .invalidateHttpSession(true) // 로그아웃하면 세션이 사라지게 함
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}