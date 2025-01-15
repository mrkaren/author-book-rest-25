package am.itspace.authorbookrest.converter;

import am.itspace.authorbookrest.dto.AuthorDto;
import am.itspace.authorbookrest.dto.SaveAuthorRequest;
import am.itspace.authorbookrest.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter {

    public AuthorDto fromEntityToDto(Author author) {
        return AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .phone(author.getPhone())
                .gender(author.getGender())
                .build();
    }

    public Author fromDtoToEntity(SaveAuthorRequest authorRequest) {
        return Author.builder()
                .name(authorRequest.getName())
                .surname(authorRequest.getSurname())
                .phone(authorRequest.getPhone())
                .gender(authorRequest.getGender())
                .dateOfBirthday(authorRequest.getDateOfBirthday())
                .build();
    }



}
