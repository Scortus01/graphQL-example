package co.edu.udem.isv.ejemplographql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

@Entity
public class Post {
    @Id
    private String id;
    private String title;
    private String text;
    private String category;
    private String authorId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthorId() {
        return authorId;
    }

    @SchemaMapping(typeName = "Post", field = "authorId")
    public String getAuthorId(Post post) {
        return post.getAuthorId();
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
