package com.spring.Blog.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] AUTH_LIST = { //URIs that don't need authentication
        "/",
        "/posts",
        "/posts/{id}"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests()
                .antMatchers(AUTH_LIST).permitAll() // authorized URIs
                .anyRequest().authenticated() // others need to be authenticated
                .and().formLogin().permitAll() // access to login page, may alter later to customized html page
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")); // URL logout path
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Rafael").password("{noop}devjava").roles("ADMIN");
    } // user authenticated in memory who's able to access the blog

    @Override
    public void configure(WebSecurity web) throws Exception { // bootstrap cdn doesn't need it, other ones should add static directories
        web.ignoring().antMatchers("/bootstrap/**");
    }


//@Bean // password encoder method
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//}




//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((AUTH_LIST) -> AUTH_LIST.anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
//        return http.build();
//    }

}
