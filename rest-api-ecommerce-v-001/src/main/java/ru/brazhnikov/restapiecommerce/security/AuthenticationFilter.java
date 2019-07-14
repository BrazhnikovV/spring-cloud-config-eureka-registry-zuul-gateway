package ru.brazhnikov.restapiecommerce.security;

import java.util.Optional;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

/**
 * AuthenticationFilter - класс фильтр для извлечения токена аутентификации из заголовков запроса
 *
 * @version 1.0.1
 * @package ru.brazhnikov.restapiecommerce.security
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
public class AuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    /**
     * AuthenticationFilter - Извлечь токен аутентификации из заголовков запроса
     * @param requiresAuth
     */
    public AuthenticationFilter( final RequestMatcher requiresAuth ) {
        super( requiresAuth );
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse ) throws AuthenticationException, IOException, ServletException {

        // Authorization: Bearer TOKEN
        // ---------------------------
        Optional<String> tokenParam = Optional.ofNullable( httpServletRequest.getHeader( AUTHORIZATION ) );

        String token = StringUtils.isNotEmpty( httpServletRequest.getHeader( AUTHORIZATION ) )
                ? httpServletRequest.getHeader( AUTHORIZATION )
                : "";

        token = StringUtils.removeStart( token, "Bearer" ).trim();
        Authentication requestAuthentication = new UsernamePasswordAuthenticationToken( token, token );
        return getAuthenticationManager().authenticate( requestAuthentication );
    }

    @Override
    protected void successfulAuthentication(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final FilterChain chain,
            final Authentication authResult ) throws IOException, ServletException {

        SecurityContextHolder.getContext().setAuthentication( authResult );
        chain.doFilter( request, response );
    }
}
