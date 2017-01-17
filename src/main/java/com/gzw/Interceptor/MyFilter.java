package com.gzw.Interceptor;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by gzw on 2017/1/17.
 */
@WebFilter(filterName="myFilter",urlPatterns="/*")
public class MyFilter implements Filter {

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        String type = request.getHeader("custom_type");
        String path = request.getServletPath();
        String isHasForward = (String) request.getAttribute("is_has_forward");
        if(isHasForward!=null && isHasForward.equals("true")){
            return ;
        }
        String url;
        request.setAttribute("is_has_forward","true");
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
        //chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器初始化");
    }

}
