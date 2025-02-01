package com.blog.demo.autor.Controller;

import com.blog.demo.autor.model.Author;
import com.blog.demo.autor.repository.AuthorRepository;
import com.blog.demo.autor.services.AuthorService;
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
        return service.saveProduct(pAuth);
    }

    @GetMapping
    public List<Author> findAllAuthor() {
        return service.getProducts();
    }

    @GetMapping("{id}")
    public Author findAuthorById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PutMapping
    public Author updateAuthor(@RequestBody Author product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("{id}")
    public String deleteAuthor(@PathVariable Long id) {
        return service.deleteProduct(id);
    }
}
