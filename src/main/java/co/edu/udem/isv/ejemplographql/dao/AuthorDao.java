package co.edu.udem.isv.ejemplographql.dao;

import co.edu.udem.isv.ejemplographql.model.Author;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AuthorDao {
    private final List<Author> authors;

    public AuthorDao(){
        authors = new ArrayList<>();
        for (int authorId = 0; authorId < 10; ++authorId) {
            Author author = new Author();
            author.setId("Author" + authorId);
            author.setName("Author " + authorId);
            author.setThumbnail("http://example.com/authors/" + authorId);
            authors.add(author);
        }
    }
    public Optional<Author> getAuthor(String id) {
        return authors.stream()
                .filter(author -> id.equals(author.getId()))
                .findFirst();
    }
}
