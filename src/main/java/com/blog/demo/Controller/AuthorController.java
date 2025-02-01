package com.blog.demo.Controller;

import com.blog.demo.model.Author;
import com.blog.demo.services.AuthorService;
import com.blog.demo.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {
    @Autowired
    private AuthorService service;

    @PostMapping
    public Author addAuthor(@RequestBody Author pAuth) {
        return service.saveAuthor(pAuth);
    }

    @GetMapping
    public GenericResponse<List<Author>> findAllAuthor() {
        return service.getAuthors();
    }

    @GetMapping("{id}")
    public Author findAuthorById(@PathVariable int id) {
        return service.getAuthorById(id);
    }

    @PutMapping
    public Author updateAuthor(@RequestBody Author product) {
        return service.updateAuthor(product);
    }

    @DeleteMapping("{id}")
    public String deleteAuthor(@PathVariable Long id) {
        return service.deleteAuthor(id);
    }
}
