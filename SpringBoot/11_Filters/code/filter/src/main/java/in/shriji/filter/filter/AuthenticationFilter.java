package in.shriji.filter.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest=(HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse=(HttpServletResponse) servletResponse;

//        ab hum chahte hai ki jaise user ka token save hota hai headers mein wo aat ahi and aagr wo avalid hai then we will forward the call to then contoller else
//        hum aage DispatcherServelet pe bhi nahi jaane denge
        String token=httpRequest.getHeader("token");
        if(token==null || !token.equals("12345"))
        {
            httpResponse.setStatus(401);
            return;
        }
//        and agar sab sahi then go to next
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
