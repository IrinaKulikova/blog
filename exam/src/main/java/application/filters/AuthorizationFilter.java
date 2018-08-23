package application.filters;

import application.service.CookieService;
import application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter("*")
@Component
public class AuthorizationFilter extends GenericFilterBean {

    @Autowired
    UserService userService;

    //https://stackoverflow.com/questions/32494398/unable-to-autowire-the-service-inside-my-authentication-filter-in-spring/32495757
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(userService==null){
            ServletContext servletContext = request.getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
            userService = webApplicationContext.getBean(UserService.class);
        }

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String requestUri = req.getRequestURI();

        String login = "";
        String password = "";
        Cookie authorizationCookie = CookieService.getAuthorizationCookie(req);
        if (authorizationCookie != null) {
            String[] data = authorizationCookie.getValue().split(":");
            login = data[0];
            password = data[1];
        }

        if (requestUri.equals("/login") || userService.checkUser(login, password) ||requestUri.equals("/") ) {
            chain.doFilter(request, response);
        } else {
            resp.sendRedirect("/");
        }
    }

    @Override
    public void destroy() {

    }
}
