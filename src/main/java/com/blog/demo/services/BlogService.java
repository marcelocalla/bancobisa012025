package com.blog.demo.services;

import com.blog.demo.model.Author;
import com.blog.demo.model.Blog;
import com.blog.demo.model.inputDto.inputBlogGralDto;
import com.blog.demo.repository.AuthorRepository;
import com.blog.demo.repository.BlogRepository;
import com.blog.demo.util.GenericResponse;
import com.blog.demo.util.MensajeServices;
import com.blog.demo.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository repository;

    @Autowired
    private AuthorRepository repositoryAuthor;

    public Blog saveBlog(Blog pBlog) throws ServiceException {
        pBlog.setId(this.generaId());
        return repository.createBlog(pBlog);
    }

    public GenericResponse<List<Blog>> getBlogs() {
        GenericResponse<List<Blog>> response = new GenericResponse<>();
        MensajeServices msg = new MensajeServices();
        List<MensajeServices> lMens = new ArrayList<>();
        var repon = repository.getAlllBlogs();
        if (repon == null || repon.isEmpty()) {
            response.setData(new ArrayList<>());
            response.setSuccess(Boolean.FALSE);
            msg.setCodigo(400);
            msg.setDescripcion("No se encotraron registros, o existe errores");
        } else {
            response.setData(repository.getAlllBlogs());
            response.setSuccess(Boolean.TRUE);
            msg.setCodigo(100);
            msg.setDescripcion("Se encotraron registros");
        }
        lMens.add(msg);
        response.setMensajes(lMens);
        return response;
    }

    public Blog getBlogById(int id) {
        return repository.findById(id);
    }

    public String deleteAuthor(Long id) {
        repository.delete(id);
        return "Blog removed " + id;
    }

    public Blog updateBlog(Blog pBlog) throws ServiceException {
        return repository.update(pBlog);
    }

    public Long generaId() {
        return System.currentTimeMillis();
    }

    public inputBlogGralDto saveBlogGral(inputBlogGralDto pBlogG) throws ServiceException {
        inputBlogGralDto response = new inputBlogGralDto();
        Long  idAuthor= 0L;
        try {
            Blog vblog = pBlogG.getBlog();
            idAuthor = this.generaId();
            vblog.setId(this.generaId()+1);
            vblog.setIdAuthor(idAuthor);
            Author vAut = pBlogG.getAuthor();
            vAut.setId(idAuthor);
            var vResultA = repositoryAuthor.createAuthor(vAut);
            var vResultB = repository.createBlog(vblog);
            response.setAuthor(vResultA);
            response.setBlog(vResultB);
        } catch (ServiceException e) {
            throw new ServiceException("saveBlogGral", e.getMessage());
        }
        return response;
    }


}
