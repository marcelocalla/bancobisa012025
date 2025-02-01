package com.blog.demo.services;

import com.blog.demo.model.Author;
import com.blog.demo.repository.AuthorRepository;
import com.blog.demo.util.GenericResponse;
import com.blog.demo.util.MensajeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public Author saveAuthor(Author Author) {
        return repository.createAuthor(Author);
    }

    public GenericResponse<List<Author>>  getAuthors() {
        GenericResponse<List<Author>> response = new GenericResponse<>();
        MensajeServices msg= new MensajeServices();
        List<MensajeServices> lMens = new ArrayList<>();
        var repon=repository.getAllAuthores();
        if(repon == null || repon.isEmpty() ){
            response.setData(new ArrayList<>());
            response.setSuccess(Boolean.FALSE);
            msg.setCodigo(400);
            msg.setDescripcion("No se encotraron registros, o existe errores");
        }else {
            response.setData(repository.getAllAuthores());
            response.setSuccess(Boolean.TRUE);
            msg.setCodigo(100);
            msg.setDescripcion("Se encotraron registros");
        }
        lMens.add(msg);
        response.setMensajes(lMens);
        return response;
    }

    public Author getAuthorById(int id) {
        return repository.findById(id);
    }

    public String deleteAuthor(Long id) {
        repository.delete(id);
        return "Author removed !! " + id;
    }

    public Author updateAuthor(Author Author) {
        return repository.update(Author);
    }

}
