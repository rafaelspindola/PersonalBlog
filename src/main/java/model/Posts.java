package model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;


@Entity
@Table(name="TB_POSTS")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private String subject;
    @NotBlank // won't be able to have null or blank values
    private String author;
    @JsonFormat(shape =
            JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")//formats date pattern, needs ?serverTimezone=UTC addition to fix bug
    private LocalDate date;
    @NotBlank
    @Lob // property should be considered as a large object (large text/values)
    private String text;
    @NotBlank
    private String title;

//    public Posts() {
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
