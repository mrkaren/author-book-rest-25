package am.itspace.authorbookrest.service.impl;

import am.itspace.authorbookrest.dto.BookDto;
import am.itspace.authorbookrest.dto.SaveBookRequest;
import am.itspace.authorbookrest.mapper.BookMapper;
import am.itspace.authorbookrest.repository.BookRepository;
import am.itspace.authorbookrest.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public List<BookDto> findAll() {
        return bookMapper.toDtoList(bookRepository.findAll());
    }

    @Override
    public BookDto save(SaveBookRequest bookRequest) {
        return bookMapper.toDto(bookRepository.save(bookMapper.toEntity(bookRequest)));
    }

    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto findById(int id) {
        return bookMapper.toDto(bookRepository.findById(id).orElse(null));
    }
}
