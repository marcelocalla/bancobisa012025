package com.blog.demo.autor.services;

import com.blog.demo.autor.model.Author;
import com.blog.demo.autor.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository repository;

    public Author saveProduct(Author product) {
        return repository.createAuthor(product);
    }

    public List<Author> getProducts() {
        return repository.getAllAuthores();
    }

    public Author getProductById(int id) {
        return repository.findById(id);
    }

    public String deleteProduct(Long id) {
        repository.delete(id);
        return "product removed !! " + id;
    }

    public Author updateProduct(Author product) {
        return repository.update(product);
    }

}
