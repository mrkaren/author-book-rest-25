package am.itspace.authorbookrest.service.impl;

import am.itspace.authorbookrest.converter.AuthorConverter;
import am.itspace.authorbookrest.dto.AuthorDto;
import am.itspace.authorbookrest.dto.SaveAuthorRequest;
import am.itspace.authorbookrest.entity.Author;
import am.itspace.authorbookrest.repository.AuthorRepository;
import am.itspace.authorbookrest.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Primary
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorConverter authorConverter;

    @Override
    public List<AuthorDto> findAll() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDto> result = new ArrayList<>();
        for (Author author : authors) {
            result.add(authorConverter.fromEntityToDto(author));
        }
        return result;
    }

    @Override
    public Page<Author> findAll(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }

    @Override
    public AuthorDto save(SaveAuthorRequest authorRequest) {
        Author author = authorRepository.save(authorConverter.fromDtoToEntity(authorRequest));

        return authorConverter.fromEntityToDto(author);
    }

    @Override
    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public AuthorDto findById(int id) {
        Author author = authorRepository
                .findById(id)
                .orElse(null);
        if(author == null){
            return null;
        }
        return authorConverter.fromEntityToDto(author);
    }

    @Override
    public Optional<Author> findByPhone(String phone) {
        return authorRepository.findByPhone(phone);
    }
}
