package in.shriji.filter.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
public class LoggingFilter implements Filter {


    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("request entering in logging filter ");
//        filterChain.doFilter(servletRequest,servletResponse);
//        System.out.println("request leaving the logging filters");

//        request entering in logging filter
//        student created
//        request leaving the logging filters

        HttpServletRequest httpRequest=(HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse=(HttpServletResponse) servletResponse;

        System.out.println("Incoming Request is"+httpRequest.getMethod()+httpRequest.getRequestURI());

        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Response status is"+httpResponse.getStatus());
    }
}
