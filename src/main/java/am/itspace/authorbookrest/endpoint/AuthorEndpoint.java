package am.itspace.authorbookrest.endpoint;

import am.itspace.authorbookrest.dto.AuthorDto;
import am.itspace.authorbookrest.dto.SaveAuthorRequest;
import am.itspace.authorbookrest.service.AuthorService;
import am.itspace.authorbookrest.service.security.CurrentUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthorEndpoint {

    private final AuthorService authorService;

    @GetMapping(value = "/authors", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AuthorDto>> getAll(@AuthenticationPrincipal CurrentUser currentUser) {
      log.info("request from {} user", currentUser.getUsername());

        return ResponseEntity.ok(authorService.findAll());
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<AuthorDto> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok(authorService.findById(id));
    }

    @PostMapping("/authors")
    public ResponseEntity<?> create(@RequestBody SaveAuthorRequest authorRequest) {
        if (authorService.findByPhone(authorRequest.getPhone()).isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .build();
        }
        AuthorDto authorFromDb = authorService.save(authorRequest);

        return ResponseEntity.ok(authorFromDb);
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        authorService.deleteById(id);
        return ResponseEntity
                .ok()
                .build();
    }

}
