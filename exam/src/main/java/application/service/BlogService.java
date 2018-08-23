package application.service;

import application.businessLogic.entity.Blog;
import application.repositories.RepositoryBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private RepositoryBlog repositoryBlog;

    public List<Blog> findAll() {
        return repositoryBlog.findAll();
    }

    public void save(Blog blog){repositoryBlog.save(blog);}

}
