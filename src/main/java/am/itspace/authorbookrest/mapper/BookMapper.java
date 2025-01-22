package am.itspace.authorbookrest.mapper;

import am.itspace.authorbookrest.dto.BookDto;
import am.itspace.authorbookrest.dto.SaveBookRequest;
import am.itspace.authorbookrest.entity.Author;
import am.itspace.authorbookrest.entity.Book;
import am.itspace.authorbookrest.exception.AuthorNotFoundException;
import am.itspace.authorbookrest.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class BookMapper {

    @Autowired
    private AuthorRepository authorRepository;

    public abstract BookDto toDto(Book book);

    public abstract List<BookDto> toDtoList(List<Book> books);

    @Mapping(target = "author", expression = "java(findAuthorById(bookRequest.getAuthorId()))")
    @Mapping(target = "createdAt", expression = "java(new java.util.Date())")
    public abstract Book toEntity(SaveBookRequest bookRequest);

    protected Author findAuthorById(int id) {
        return authorRepository.findById(id).orElseThrow(()-> new AuthorNotFoundException("Author not found with " + id +" id"));
    }

}
