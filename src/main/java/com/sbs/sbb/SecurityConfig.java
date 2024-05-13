package com.sbs.sbb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration  // @ : 어너테이션
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        (authorizeHttpRequests) -> authorizeHttpRequests
                        // 로그인이 없어도 들어갈 수 있는 것 (사이즈 허용)
                        .requestMatchers(new AntPathRequestMatcher("/question/list")).permitAll() // "/**(페이지 주소)" 는  모든 접속 허용
                        .requestMatchers(new AntPathRequestMatcher("/question/detail/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/user/login")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/style.css")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                         // 인증된(로그인한) 사람은 접근 하능하게 해주는것
                        .anyRequest().authenticated()
                )
                .formLogin((formLogin) -> formLogin
                        // GET
                        // 시큐리티에게 우리가 만든 로그인 페이지 url을 알려준다
                        // 만약 이걸 하지 않으면 기본적으로 로그인 페이지 url은 "/login" 이다.
                        .loginPage("/user/login")
                        // POST
                        // 시큐리티에게 로그인 폼 처리 url을 알려준다.
                        .loginProcessingUrl("/user/login")
                        .defaultSuccessUrl("/"))
        ;
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}