package in.shriji.interceptor.inceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("request is coming in preHandle.....");
        System.out.println("method name is"+request.getMethod());
        System.out.println("uri is"+request.getRequestURI());
        System.out.println("token header is"+request.getHeader("token"));
        if(handler instanceof HandlerMethod handlerMethod)
        {
            System.out.println("controller name is"+handlerMethod.getBean().getClass());
            System.out.println("controller method is"+handlerMethod.getMethod().getName());
        }
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("response status is "+response.getStatus());
    }
}
