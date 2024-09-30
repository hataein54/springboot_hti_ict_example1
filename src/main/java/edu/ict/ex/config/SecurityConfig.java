package edu.ict.ex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.ict.ex.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록됨
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	
   @Override
   public void configure(WebSecurity web) throws Exception {
      // web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
      //web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
   }
   
   @Override
   protected void configure(HttpSecurity http) throws Exception {
        //우선 CSRF설정을 해제한다.
        //초기 개발시만 해주는게 좋다.
	   http.csrf(csrf -> csrf.disable());
      
      http.authorizeHttpRequests()
      .antMatchers("/**")
      .permitAll();

      //로그인 폼 커스텀 마이징
      http.formLogin()
         .loginPage("/login")  //loginPage() 는 말그대로 로그인할 페이지 url 이고
          .usernameParameter("id")
          .passwordParameter("pw")
          .defaultSuccessUrl("/");
       
      
   }
   
   
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       
//      auth.inMemoryAuthentication()
//           .withUser("user").password("{noop}user").roles("USER").
//           and()
//           .withUser("admin").password("{noop}admin").roles("ADMIN");
	   
	   auth.userDetailsService(customUserDetailsService)
	   .passwordEncoder(passwordEncoder());
	   
   
   }
      
   @Bean
   public PasswordEncoder passwordEncoder() {        
     return new BCryptPasswordEncoder();
   }
   

//   @Override
//   protected void configure(HttpSecurity http) throws Exception {
//
//      http.authorizeRequests()
//            .antMatchers("/member/**").authenticated()
//            .antMatchers("/admin/**").authenticated()
//            .antMatchers("/**")
//            .permitAll();
//
//      http.formLogin()
//            .loginPage("/login")
//            .defaultSuccessUrl("/")
//            .permitAll();
//
//      http.logout()
//            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//            .logoutSuccessUrl("/login")
//            .invalidateHttpSession(true);
//
//      http.exceptionHandling()
//            .accessDeniedPage("/denied");
//      }
//      
//      @Override
//       public void configure(AuthenticationManagerBuilder auth) throws Exception {
//           //auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
//       }
   
}
