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

    /**
     * Metodo para adcionar autores
     * @param pAuth
     * @return
     */
    @PostMapping
    public Author addAuthor(@RequestBody Author pAuth) {
        return service.saveAuthor(pAuth);
    }

    /**
     * Busca todos los autores
     * @return
     */
    @GetMapping
    public GenericResponse<List<Author>> findAllAuthor() {
        return service.getAuthors();
    }

    /**
     * Busca los autores por el id
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Author findAuthorById(@PathVariable int id) {
        return service.getAuthorById(id);
    }

    /**
     * Actualiza la informacion de los autores
     * @param product
     * @return
     */

    @PutMapping
    public Author updateAuthor(@RequestBody Author product) {
        return service.updateAuthor(product);
    }

    /**
     * Borra la informacion de un author por el id
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public String deleteAuthor(@PathVariable Long id) {
        return service.deleteAuthor(id);
    }
}
