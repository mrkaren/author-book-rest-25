package am.itspace.authorbookrest.repository;

import am.itspace.authorbookrest.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Optional<Author> findByPhone(String phone);

}

