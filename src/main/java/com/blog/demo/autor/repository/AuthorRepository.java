package com.blog.demo.autor.repository;

import com.blog.demo.autor.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AuthorRepository {
    private List<Author> listAuthor = new ArrayList<Author>();

    public Author createAuthor(Author pAuth) {
        listAuthor.add(pAuth);
        return pAuth;
//        list = List.of(
//                new Product(1, "product 1", 10, 1000),
//                new Product(2, "product 2", 20, 2000),
//                new Product(3, "product 3", 30, 3000)
//        );
    }

    public List<Author> getAllAuthores() {
        return listAuthor;
    }

    public Author findById(int id) {
        for (int i = 0; i < listAuthor.size(); i++) {
            if (listAuthor.get(i).getId() == (id)) {
                return listAuthor.get(i);
            }
        }
        return null;
    }

    public List<Author> search(String name) {
        return listAuthor.stream().filter(x -> x.getNombres().startsWith(name)).collect(Collectors.toList());
    }

    public String delete(Long id) {
        listAuthor.removeIf(x -> x.getId() == (id));
        return null;
    }

    public Author update(Author pAut) {
        int idx = 0;
        Long id = 0L;
        for (int i = 0; i < listAuthor.size(); i++) {
            if (listAuthor.get(i).getId() == (pAut.getId())) {
                id = pAut.getId();
                idx = i;
                break;
            }
        }

        Author authorUpdate = new Author();
        authorUpdate.setId(id);
        authorUpdate.setNombres(pAut.getNombres());
        authorUpdate.setApellidoPaterno(pAut.getApellidoPaterno());
        authorUpdate.setApellidoMaterno(pAut.getApellidoMaterno());
        authorUpdate.setCorreo(pAut.getCorreo());
        authorUpdate.setFechaNacimiento(pAut.getFechaNacimiento());
        authorUpdate.setPaisResidencia(pAut.getPaisResidencia());
        listAuthor.set(idx, authorUpdate);
        return authorUpdate;
    }

}
