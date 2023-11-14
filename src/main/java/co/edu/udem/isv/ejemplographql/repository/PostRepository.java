package co.edu.udem.isv.ejemplographql.repository;

import co.edu.udem.isv.ejemplographql.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, String> { }
