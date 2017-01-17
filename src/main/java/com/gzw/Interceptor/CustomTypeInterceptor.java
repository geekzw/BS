package com.gzw.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gzw on 2017/1/17.
 */
public class CustomTypeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String type = request.getHeader("custom_type");
        String url;
        if(type!=null && type.equals("app")){
            url = request.getScheme() +"://" + request.getServerName()
                    + ":" +request.getServerPort()
                    + "/app"
                    + request.getServletPath();
        }else{
            url = request.getScheme() +"://" + request.getServerName()
                    + ":" +request.getServerPort()
                    + "/web"
                    + request.getServletPath();
        }
        request.getRequestDispatcher(url).forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
