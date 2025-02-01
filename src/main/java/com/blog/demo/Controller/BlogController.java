package com.blog.demo.Controller;

import com.blog.demo.model.inputDto.inputBlogGralDto;
import com.blog.demo.services.AuthorService;
import com.blog.demo.services.BlogService;
import com.blog.demo.util.GenericResponse;
import com.blog.demo.util.MensajeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")

public class BlogController {
    @Autowired
    private AuthorService service;

    @Autowired
    private BlogService serviceBlog;

    @PostMapping(path = "/createBlog", consumes = "application/json")
    public GenericResponse<inputBlogGralDto>   creaBlog(@RequestBody inputBlogGralDto pInput) {

        GenericResponse<inputBlogGralDto> response = new GenericResponse<>();
        MensajeServices msg= new MensajeServices();
        List<MensajeServices> lMens = new ArrayList<>();
        try{
            var repon=serviceBlog.saveBlogGral(pInput);
            if(repon == null){
                response.setData(null);
                response.setSuccess(Boolean.FALSE);
                msg.setCodigo(400);
                msg.setDescripcion("Existe errores");
            }else {
                response.setData(repon);
                response.setSuccess(Boolean.TRUE);
                msg.setCodigo(200);
                msg.setDescripcion("Se registro correctamente");
            }
            lMens.add(msg);
            response.setMensajes(lMens);
        }catch(Exception e ){
            response.setData(null);
            response.setSuccess(Boolean.FALSE);
            msg.setCodigo(401);
            msg.setDescripcion(e.getMessage());
        }
        return response;
    }


}
