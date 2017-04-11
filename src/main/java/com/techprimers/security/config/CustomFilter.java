package com.techprimers.security.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

@Component
public class CustomFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Init::called");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter::called");

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        Principal userPrincipal = request.getUserPrincipal();
        System.out.println("userPrinciple::"+userPrincipal);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("Destroy::called");

    }
}
