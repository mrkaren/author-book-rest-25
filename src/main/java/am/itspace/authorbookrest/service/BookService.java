package am.itspace.authorbookrest.service;


import am.itspace.authorbookrest.dto.BookDto;
import am.itspace.authorbookrest.dto.SaveBookRequest;

import java.util.List;

public interface BookService {

    List<BookDto> findAll();

    BookDto save(SaveBookRequest bookRequest);

    void deleteById(int id);

    BookDto findById(int id);

}
