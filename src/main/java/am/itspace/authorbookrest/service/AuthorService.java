package am.itspace.authorbookrest.service;


import am.itspace.authorbookrest.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();

    Page<Author> findAll(Pageable pageable);

    Author save(Author author);

    void deleteById(int id);

    Author findById(int id);

}
