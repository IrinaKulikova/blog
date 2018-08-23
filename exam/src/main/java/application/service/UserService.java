package application.service;

import application.businessLogic.entity.User;
import application.repositories.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private RepositoryUser repositoryUser;

    public boolean checkUser(String login, String password) {
        List<User> users = repositoryUser.findAll();
        boolean exists = false;
        for (User user : users) {
            if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public List<User> findAll() {
        return repositoryUser.findAll();
    }

}
