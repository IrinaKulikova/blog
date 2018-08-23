package application.businessLogic.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;

    @Column(columnDefinition = "text")
    String text;

    public Blog() {
        this("", "");
    }

    public Blog(String title, String text) {
        this.text = text;
        this.title = title;
    }
}
