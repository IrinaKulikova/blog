package application.repositories;

import application.businessLogic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUser extends JpaRepository <User, Integer>{
}
