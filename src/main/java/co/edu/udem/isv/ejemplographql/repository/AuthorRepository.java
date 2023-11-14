package co.edu.udem.isv.ejemplographql.repository;

import co.edu.udem.isv.ejemplographql.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String> { }
