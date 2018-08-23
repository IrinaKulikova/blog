package application.repositories;

import application.businessLogic.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryBlog extends JpaRepository<Blog,Integer> {
}
