package application.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieService {
    public static Cookie getAuthorizationCookie(HttpServletRequest req) {
        Cookie authorizationCookie = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    authorizationCookie = c;
                    break;
                }
            }
        }
        return authorizationCookie;
    }
}
