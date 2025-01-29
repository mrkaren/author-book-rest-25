package am.itspace.authorbookrest.mapper;

import am.itspace.authorbookrest.dto.AuthorResponseDto;
import am.itspace.authorbookrest.dto.SaveAuthorRequest;
import am.itspace.authorbookrest.entity.Author;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

//  @Mapping(source = "name", target = "name")
    AuthorResponseDto toDto(Author author);

    List<AuthorResponseDto> toDtoList(List<Author> authors);

    Author toEntity(SaveAuthorRequest authorRequest);

}
