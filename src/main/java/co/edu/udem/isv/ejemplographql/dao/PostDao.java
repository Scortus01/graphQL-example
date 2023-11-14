package co.edu.udem.isv.ejemplographql.dao;

import co.edu.udem.isv.ejemplographql.model.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostDao {

    private final List<Post> posts;

    public PostDao() {
        posts = new ArrayList<>();
        for (int postId = 0; postId < 10; ++postId) {
            for (int authorId = 0; authorId < 10; ++authorId) {
                Post post = new Post();
                post.setId("Post" + authorId + postId);
                post.setTitle("Post " + authorId + ":" + postId);
                post.setCategory("Post category");
                post.setText("Post " + postId + " + by author " + authorId);
                post.setAuthorId("Author" + authorId);
                posts.add(post);
            }
        }
    }

    public List<Post> getRecentPosts(int count, int offset) {
        return posts.stream()
                .skip(offset)
                .limit(count)
                .collect(Collectors.toList());
    }

    public void savePost(Post post) {

        posts.add(0, post);
    }
}
