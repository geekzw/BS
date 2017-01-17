package com.gzw.Interceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by gzw on 2017/1/17.
 */
public class MyServlet extends HttpServlet {

    private static final long serialVersionUID = -8685285401859800066L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    }
}
