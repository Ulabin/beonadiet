package com.beonadiet.beonadiet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.beonadiet.beonadiet.handler.TaskImplementingLogoutHandler;
// import com.beonadiet.beonadiet.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  //유저 정보를 가져올 클래스
  // private final UserService userService; 
  
  //인증을 무시할 경로 설정
  // @Override
  // public void configure(WebSecurity web) {
  //   web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
  // }

  @Override
  //http 관련 인증 설정 가능
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
      .antMatchers("/adminOnly").hasAuthority("ROLE_ADMIN")
      // .antMatchers("/images/**").permitAll()
      // .antMatchers("/css/**").permitAll()
      // .antMatchers("/js/**").permitAll()
      // .antMatchers("/font/**").permitAll()
      .antMatchers("/**").permitAll()  // 넓은 범위의 URL을 아래에 배치한다.
      .anyRequest().authenticated() //어떤 요청이든 '인증' -> 스프링서버로 요청이 오는 모든 request에 대해서 인증을 거치겠다.
    .and()
      .formLogin() //로그인에 대한 설정
        .loginPage("/login") //로그인 페이지 링크
        .usernameParameter("user_id")
        .defaultSuccessUrl("/") //로그인 성공시 연결되는 주소
        .failureUrl("/login?error").permitAll() 
    .and()
      .logout() //로그아웃 관련 설정
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .addLogoutHandler(new TaskImplementingLogoutHandler()).permitAll()
        .logoutSuccessUrl("/") //로그아웃 성공시 연결되는 주소
        .invalidateHttpSession(true) //로그아웃시 저장해 둔 세션 날리기
      // 로그아웃 기본 url은 (/logout)
      // 새로 설정하려면 .logoutUrl("url") 사용  
    .and()
      .exceptionHandling().accessDeniedPage("/403");
      //.exceptionHandling() 만약 권한이 없는 사용자가 있다면 /403 으로 리턴
    
  }
  
  // @Override
  // //로그인시 필요한 정보를 가져옴
  // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  //   //인메모리 방식
  //   // auth.inMemoryAuthentication() 
  //   // .withUser("admin").password(passwordEncoder().encode("1234")).roles("ADMIN")
  //   // .and()
  //   // .withUser("user").password(passwordEncoder().encode("1234")).roles("USER");

  //   // auth.userDetailsService(userService) //유저 정보는 userService에서 가져온다
  //   //       .passwordEncoder(new BCryptPasswordEncoder()); //패스워드 인코더는 passwordEncoder(BCrypt 사용)

  // }
  
  // passwordEncoder() 추가
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}