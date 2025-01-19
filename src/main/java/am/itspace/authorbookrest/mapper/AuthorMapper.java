package am.itspace.authorbookrest.mapper;

import am.itspace.authorbookrest.dto.AuthorDto;
import am.itspace.authorbookrest.dto.SaveAuthorRequest;
import am.itspace.authorbookrest.entity.Author;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

//  @Mapping(source = "name", target = "name")
    AuthorDto toDto(Author author);

    List<AuthorDto> toDtoList(List<Author> authors);

    Author toEntity(SaveAuthorRequest authorRequest);

}
