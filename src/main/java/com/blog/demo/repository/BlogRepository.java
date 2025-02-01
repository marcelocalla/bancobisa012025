package com.blog.demo.repository;

import com.blog.demo.model.Author;
import com.blog.demo.model.Blog;
import com.blog.demo.util.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BlogRepository {
    private List<Blog> listBlog = new ArrayList<Blog>();

    public Blog createBlog(Blog pblog) throws ServiceException {
        try {
            listBlog.add(pblog);
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), "createBlog");
        }
        return pblog;
    }

    public List<Blog> getAlllBlogs() {
        return listBlog;
    }

    public Blog findById(Long id) {
        System.out.println("findById::"+id);
        for (int i = 0; i < listBlog.size(); i++) {
            System.out.println(""+listBlog.get(i).getId());
            if (listBlog.get(i).getId().equals(id)) {
                return listBlog.get(i);
            }
        }
        return null;
    }

    public List<Blog> search(String tema) {
        return listBlog.stream().filter(x -> x.getTema().startsWith(tema)).collect(Collectors.toList());
    }

    public String delete(Long id) {
        listBlog.removeIf(x -> x.getId() == (id));
        return null;
    }

    public Blog update(Blog pBlog) throws ServiceException {
        int idx = 0;
        Long id = 0L;
        try {
            for (int i = 0; i < listBlog.size(); i++) {
                if (listBlog.get(i).getId() == (pBlog.getId())) {
                    id = pBlog.getId();
                    idx = i;
                    break;
                }
            }
            Blog blogUpdate = new Blog();
            blogUpdate.setId(id);
            blogUpdate.setComentarios(pBlog.isComentarios());
            blogUpdate.setContenido(pBlog.getContenido());
            blogUpdate.setTema(pBlog.getTema());
            blogUpdate.setCodigoPeriodicidad(pBlog.getCodigoPeriodicidad());
            blogUpdate.setTitulo(pBlog.getTitulo());
            blogUpdate.setIdAuthor(pBlog.getIdAuthor());
            listBlog.set(idx, blogUpdate);
            return blogUpdate;
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), "update");
        }
    }

    public Blog findByTitulo(String pTit) {
        for (int i = 0; i < listBlog.size(); i++) {
            if (listBlog.get(i).getTitulo().equals(pTit)) {
                return listBlog.get(i);
            }
        }
        return null;
    }


}
