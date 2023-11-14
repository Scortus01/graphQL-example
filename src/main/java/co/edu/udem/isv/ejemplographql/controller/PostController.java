package co.edu.udem.isv.ejemplographql.controller;

import co.edu.udem.isv.ejemplographql.dao.AuthorDao;
import co.edu.udem.isv.ejemplographql.dao.PostDao;
import co.edu.udem.isv.ejemplographql.model.Author;
import co.edu.udem.isv.ejemplographql.model.Post;
import co.edu.udem.isv.ejemplographql.repository.AuthorRepository;
import co.edu.udem.isv.ejemplographql.repository.PostRepository;
import org.apache.juli.logging.Log;
import org.springframework.graphql.client.GraphQlClientException;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

@Controller
public class PostController {

    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;

    public PostController(PostRepository postRepository, AuthorRepository authorRepository) {
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }

    @QueryMapping
    public List<Post> recentPosts(@Argument int count, @Argument int offset) {
        return postRepository.findAll();
    }

    @MutationMapping
    public Author createAuthor(@Argument String id, @Argument String name, @Argument String thumbnail) {
        Author newAuthor = new Author();
        newAuthor.setId(id);
        newAuthor.setName(name);
        newAuthor.setThumbnail(thumbnail);
        authorRepository.save(newAuthor);
        return newAuthor;
    }

    @SchemaMapping(typeName = "Post", field = "author")
    public Optional<Author> getAuthor(Post post) {
        return authorRepository.findById(post.getAuthorId());
    }

    @MutationMapping
    public Post createPost(@Argument String id, @Argument String title, @Argument String text,
                           @Argument String category, @Argument String authorId) {
            Optional<Author> authorOptional = authorRepository.findById(authorId);
            if (authorOptional.isEmpty()) {
                throw new RuntimeException("No author found");
            }

            Post post = new Post();
            post.setId(id);
            post.setTitle(title);
            post.setText(text);
            post.setCategory(category);
            post.setAuthorId(authorId);
            postRepository.save(post);
            return post;
    }
}
