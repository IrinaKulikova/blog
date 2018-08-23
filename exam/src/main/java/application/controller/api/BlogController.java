package application.controller.api;

import application.businessLogic.dto.BlogDto;
import application.businessLogic.entity.Blog;
import application.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/blogs")
@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public List<Blog> index(Model model)
    {
        return blogService.findAll();
    }

    @PostMapping("/")
    public String addBlog(BlogDto blogDto, Model model)
    {
       blogService.save(new Blog(blogDto.getTitle(), blogDto.getText()));
       return "redirect:/";
    }

    @GetMapping("/add")
    public String add()
    {
        return "addblog";
    }
}
