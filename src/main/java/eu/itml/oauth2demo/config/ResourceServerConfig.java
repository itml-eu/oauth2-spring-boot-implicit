package eu.itml.oauth2demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@EnableResourceServer
@Order(-20)
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access","/oauth/token").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }

}
