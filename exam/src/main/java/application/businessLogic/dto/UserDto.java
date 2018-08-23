package application.businessLogic.dto;

import lombok.Data;

@Data
public class UserDto {

    String login;
    String password;

    public  UserDto(String login, String password){
        this.login=login;
        this.password=password;
    }

    public  UserDto() {
        this("","");
    }
}
