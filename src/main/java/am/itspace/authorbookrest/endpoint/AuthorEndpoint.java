package am.itspace.authorbookrest.endpoint;

import am.itspace.authorbookrest.entity.Author;
import am.itspace.authorbookrest.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorEndpoint {

    private final AuthorService authorService;

    @GetMapping(value = "/authors", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Author> getAll() {
        return authorService.findAll();
    }

    @GetMapping("/authors/{id}")
    public Author getById(@PathVariable("id") int id) {
        return authorService.findById(id);
    }

    @PostMapping("/authors")
    public Author create(@RequestBody Author author) {
        author.setId(0);
        return authorService.save(author);
    }

    @DeleteMapping("/authors/{id}")
    public void delete(@PathVariable("id") int id) {
        authorService.deleteById(id);
    }

}
