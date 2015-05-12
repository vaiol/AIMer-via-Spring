package com.kpi.stepanov.rest.config;

import com.kpi.stepanov.rest.filter.CSRFHeaderFilter;
import com.kpi.stepanov.rest.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN", "USER");
    }

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(getShaPasswordEncoder());
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic().and().authorizeRequests()
//            .antMatchers("/user/**").access("hasRole('ROLE_USER')")
//            .antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
//            .anyRequest().permitAll();

//                .failureUrl("/login?error")
//                .permitAll();
//        http.logout()
//            .permitAll()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login?logout")
//
        http.addFilterAfter(getCSRFHeaderFilter(), CsrfFilter.class)
                .headers()
                .cacheControl()
                .xssProtection();
        http.httpBasic();
        http.authorizeRequests()
                .antMatchers("/user").authenticated()
                .antMatchers("/**").permitAll();
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/#/logout")
                .invalidateHttpSession(true);
//        http.addFilterAfter(new CSRFHeaderFilter(), CsrfFilter.class);
//        http.csrf().csrfTokenRepository(csrfTokenRepository());
//        http.csrf().disable();
        http.sessionManagement().maximumSessions(10).sessionRegistry(sessionRegistry());
    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }

    @Bean
    public CSRFHeaderFilter getCSRFHeaderFilter() {
        return new CSRFHeaderFilter();
    }

    @Bean
    public ShaPasswordEncoder getShaPasswordEncoder() {
        return new ShaPasswordEncoder();
    }

}