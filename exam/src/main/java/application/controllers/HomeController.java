package application.controllers;

import application.service.BlogService;
import application.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {
        Cookie authorizationCookie = CookieService.getAuthorizationCookie(request);
        model.addAttribute("admin", authorizationCookie == null?false:true);
        model.addAttribute("blogs", blogService.findAll());
        return "index";
    }
}
