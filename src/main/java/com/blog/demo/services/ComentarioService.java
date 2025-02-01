package com.blog.demo.services;

import com.blog.demo.model.ComentarioBlog;
import com.blog.demo.model.inputDto.inputComentarioDto;
import com.blog.demo.repository.AuthorRepository;
import com.blog.demo.repository.BlogRepository;
import com.blog.demo.repository.ComentarioRepository;
import com.blog.demo.util.ServiceException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {

    @Autowired
    private BlogRepository repositoryBlog;

    @Autowired
    private AuthorRepository repositoryAuthor;

    @Autowired
    private ComentarioRepository repository;

    public inputComentarioDto saveComentarioGral(inputComentarioDto pCome) throws ServiceException {
        inputComentarioDto response = new inputComentarioDto();
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

        try{
            ComentarioBlog comentario =pCome.getComentario();
            var vBlog =repositoryBlog.findByTitulo(pCome.getTituloBlog());
            comentario.setIdAuthor(vBlog.getIdAuthor());
            comentario.setIdBlog(vBlog.getId());
            var vAuth= repositoryAuthor.findByOthers(pCome.getAuth());
            if(vAuth != null){
                comentario.setIdAuthor(vAuth.getId());
            }
            System.out.println(""+ comentario.getIdBlog()+" "+comentario.getIdAuthor());
            comentario.setId(repository.generateId());
            System.out.println("json co,mentario :"+gson.toJson(comentario));
            var vComentario =repository.createComent(comentario);
            response.setAuth(pCome.getAuth());
            response.setTituloBlog(pCome.getTituloBlog());
            response.setComentario(vComentario);
        }catch(Exception e){
            throw new ServiceException("saveComentarioGral",e.getMessage());
        }
        return response;
    }


}
