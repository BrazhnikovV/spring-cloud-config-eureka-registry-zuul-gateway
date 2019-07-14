package ru.brazhnikov.restapiecommerce.security;

import org.springframework.http.HttpStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

/**
 * SecurityJavaConfig - конфигурационный класс настройки безопасности
 *
 * @version 1.0.1
 * @package ru.brazhnikov.restapiecommerce.entities
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity( securedEnabled = true )
public class SecurityJavaConfig extends WebSecurityConfigurerAdapter {

    /**
     * @access public
     * @var AuthenticationProvider provider - отвечает за поиск пользователя на основе токена аутентификации,
     * отправленного клиентом в заголовке.
     */
    public AuthenticationProvider provider;

    /**
     * @access private
     * @var RequestMatcher PROTECTED_URLS - список url адресов, которые необходимо проверить(!Fixme)
     */
    private static final RequestMatcher PROTECTED_URLS = new OrRequestMatcher(
        new AntPathRequestMatcher( "/api/**" )
    );

    /**
     * SecurityJavaConfig - конструктор
     * @param authenticationProvider
     */
    public SecurityJavaConfig( final AuthenticationProvider authenticationProvider ) {
        super();
        this.provider = authenticationProvider;
    }

    @Override
    protected void configure( final AuthenticationManagerBuilder auth ) {
        auth.authenticationProvider( this.provider );
    }

    @Override
    public void configure( final WebSecurity webSecurity ) {
        webSecurity.ignoring().antMatchers("/token/**" );
    }

    @Override
    public void configure( HttpSecurity http ) throws Exception {
        http.sessionManagement()
            .sessionCreationPolicy( SessionCreationPolicy.STATELESS )
            .and()
            .exceptionHandling()
            .and()
            .authenticationProvider( this.provider )
            .addFilterBefore( authenticationFilter(), AnonymousAuthenticationFilter.class )
            .authorizeRequests()
            .requestMatchers( PROTECTED_URLS )
            .authenticated()
            .and()
            .csrf().disable()
            .formLogin().disable()
            .httpBasic().disable()
            .logout().disable();
    }

    @Bean
    AuthenticationFilter authenticationFilter() throws Exception {
        final AuthenticationFilter filter = new AuthenticationFilter( PROTECTED_URLS );
        filter.setAuthenticationManager( authenticationManager() );
        //filter.setAuthenticationSuccessHandler(successHandler());
        return filter;
    }

    @Bean
    AuthenticationEntryPoint forbiddenEntryPoint() {
        return new HttpStatusEntryPoint( HttpStatus.FORBIDDEN );
    }
}
