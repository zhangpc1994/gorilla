package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by XH on 2016/5/16.
 */
@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        System.out.println("初始化LoginFilter...");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("进入doFilter...");

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpSession session = request.getSession(true);


        /*//解析访问的路径
        String requestURI = request.getRequestURI().substring(request.getRequestURI().indexOf("/", 1), request.getRequestURI().length());
        System.out.println("requestURL------------>"+requestURI);*/
        //String uri =request.getRequestURI();

        // 从session里取的用户名信息
        String username = (String) session.getAttribute("username");

        // 判断如果没有取到用户信息,就跳转到登陆页面
        if (null!=username && ""!=username) {
            System.out.println("可以登录！");
            chain.doFilter(request, response);

        } else {
            // 跳转到登陆页面
            System.out.println("不可以登录！");
            response.sendRedirect("/stock/login.jsp");
        }

    }

    public void destroy() {
        System.out.println("销毁LoginFilter...");
    }

}
