package cn.nancode.zm.config;

import cn.nancode.zm.utils.ValidateCodeFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Locale;

/**
 * User: nan-computer
 * Date: 2018/6/3 17:49
 * Description:
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthenticationSuccessHandler authSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler authFailedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(authFailedHandler);

        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/auth/form")
                .successHandler(authSuccessHandler)
                .failureHandler(authFailedHandler)

                .and()
                .authorizeRequests()
                .antMatchers("/", "/login", "/code/image", "/register").permitAll()
                .antMatchers("/test", "/video/**", "/api/upload/token").permitAll()
                .antMatchers("/css/**", "/js/**", "/images/**", "/lib/**", "/favicon.ico").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }
}
