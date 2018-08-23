package application.controllers;

import application.businessLogic.dto.UserDto;
import application.service.CookieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String Login() {
        return "login";
    }

    @PostMapping("/login")
    public String Enter(UserDto userDto, HttpServletResponse resp) {
        resp.addCookie(new Cookie("user", userDto.getLogin() + ":" + userDto.getPassword()));
        return "addblog";
    }

    @GetMapping("/exit")
    public String ExitBlog(HttpServletResponse resp, HttpServletRequest request) {
        Cookie userCookie=CookieService.getAuthorizationCookie(request);
        userCookie.setMaxAge(0);
        resp.addCookie(userCookie);
        return "redirect:/";
    }
}