package am.itspace.authorbookrest.service;


import am.itspace.authorbookrest.dto.AuthorDto;
import am.itspace.authorbookrest.dto.SaveAuthorRequest;
import am.itspace.authorbookrest.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<AuthorDto> findAll();

    Page<Author> findAll(Pageable pageable);

    AuthorDto save(SaveAuthorRequest authorRequest);

    void deleteById(int id);

    AuthorDto findById(int id);

    Optional<Author> findByPhone(String phone);

}
