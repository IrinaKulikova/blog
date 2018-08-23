package application.businessLogic.entity;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String login;
    String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {
        this("", "");
    }
}
