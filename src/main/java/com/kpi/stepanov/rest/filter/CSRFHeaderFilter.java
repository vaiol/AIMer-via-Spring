package com.kpi.stepanov.rest.filter;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CSRFHeaderFilter extends OncePerRequestFilter {
  //  @Override
//  protected void doFilterInternal(HttpServletRequest request,
//      HttpServletResponse response, FilterChain filterChain)
//      throws ServletException, IOException {
//    CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
//    if (csrf != null) {
//      Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
//      String token = csrf.getToken();
//      if (cookie == null || token != null && !token.equals(cookie.getValue())) {
//        cookie = new Cookie("XSRF-TOKEN", token);
//        cookie.setPath("/");
//        response.addCookie(cookie);
//      }
//    }
//    filterChain.doFilter(request, response);
//  }
  protected static final String REQUEST_ATTRIBUTE_NAME = "_csrf";
  protected static final String RESPONSE_HEADER_NAME = "X-CSRF-HEADER";
  protected static final String RESPONSE_PARAM_NAME = "X-CSRF-PARAM";
  protected static final String RESPONSE_TOKEN_NAME = "X-CSRF-TOKEN";

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, javax.servlet.FilterChain filterChain) throws ServletException, IOException {
    CsrfToken token = (CsrfToken) request.getAttribute(REQUEST_ATTRIBUTE_NAME);

    if (token != null) {
      response.setHeader(RESPONSE_HEADER_NAME, token.getHeaderName());
      response.setHeader(RESPONSE_PARAM_NAME, token.getParameterName());
      response.setHeader(RESPONSE_TOKEN_NAME, token.getToken());
    }

    filterChain.doFilter(request, response);
  }
}