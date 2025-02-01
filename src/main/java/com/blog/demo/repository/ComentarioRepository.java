package com.blog.demo.repository;

import com.blog.demo.model.Author;
import com.blog.demo.model.ComentarioBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ComentarioRepository {
    private List<ComentarioBlog> lComentario = new ArrayList<ComentarioBlog>();

    public ComentarioBlog createComent(ComentarioBlog pComentario) {
        lComentario.add(pComentario);
        return pComentario;
    }

    public List<ComentarioBlog> getAllÇoments() {
        return lComentario;
    }

    public ComentarioBlog findById(int id) {
        for (int i = 0; i < lComentario.size(); i++) {
            if (lComentario.get(i).getId() == (id)) {
                return lComentario.get(i);
            }
        }
        return null;
    }

    public List<ComentarioBlog> search(String name) {
        return lComentario.stream().filter(x -> x.getComentario().startsWith(name)).collect(Collectors.toList());
    }

    public String delete(Long id) {
        lComentario.removeIf(x -> x.getId() == (id));
        return null;
    }
    public Long generateId(){
        return System.currentTimeMillis();
    }

}
