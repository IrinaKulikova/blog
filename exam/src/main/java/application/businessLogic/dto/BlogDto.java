package application.businessLogic.dto;

import lombok.Data;

@Data
public class BlogDto {

    String title;
    String text;

    public BlogDto(String title, String text){
        this.text=text;
        this.title=title;
    }

    public BlogDto(){
        this("","");
    }
}
