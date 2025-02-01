package com.blog.demo.Controller;

import com.blog.demo.model.inputDto.inputBlogGralDto;
import com.blog.demo.model.outDto.ConsultaBlogDto;
import com.blog.demo.services.AuthorService;
import com.blog.demo.services.BlogService;
import com.blog.demo.util.GenericResponse;
import com.blog.demo.util.MensajeServices;
import com.blog.demo.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(path = "/consultaBlog", consumes = "application/json"  )
    public GenericResponse<List<ConsultaBlogDto>>  consultaBlogs() {
        GenericResponse<List<ConsultaBlogDto>> response = new GenericResponse<>();
        MensajeServices msg= new MensajeServices();
        List<MensajeServices> lMens = new ArrayList<>();
        List<ConsultaBlogDto> resp =  new ArrayList<>();
        try{
            resp = serviceBlog.consultaBlogGral();
            if(resp != null){
                response.setSuccess(Boolean.TRUE);
                msg.setCodigo(200);
                msg.setDescripcion("Se encontro datos");
                response.setData(resp);
                lMens.add(msg);
                response.setMensajes(lMens);
            }else{
                response.setData(null);
                response.setSuccess(Boolean.FALSE);
                msg.setCodigo(401);
                msg.setDescripcion("No se encontro datos");
                lMens.add(msg);
                response.setMensajes(lMens);
            }
            return response;
        }catch(ServiceException e){
            response.setData(null);
            response.setSuccess(Boolean.FALSE);
            msg.setCodigo(401);
            msg.setDescripcion(e.getMessage());
            lMens.add(msg);
            response.setMensajes(lMens);
        }
        return response;
    }

    @GetMapping(path = "/consultaBlogByid/{id}", consumes = "application/json"  )

    public GenericResponse<List<ConsultaBlogDto>>  consultaBlogsById(@PathVariable(name="id") Long id) {
        GenericResponse<List<ConsultaBlogDto>> response = new GenericResponse<>();
        MensajeServices msg= new MensajeServices();
        List<MensajeServices> lMens = new ArrayList<>();
        List<ConsultaBlogDto> resp =  new ArrayList<>();
        try{
            ConsultaBlogDto resp1 = serviceBlog.consultaBlogGralById(id);
            resp.add(resp1);
            if(resp != null){
                response.setSuccess(Boolean.TRUE);
                msg.setCodigo(200);
                msg.setDescripcion("Se encontro datos");
                response.setData(resp);
                lMens.add(msg);
                response.setMensajes(lMens);
            }else{
                response.setData(null);
                response.setSuccess(Boolean.FALSE);
                msg.setCodigo(401);
                msg.setDescripcion("No se encontro datos");
                lMens.add(msg);
                response.setMensajes(lMens);
            }
            return response;
        }catch(ServiceException e){
            response.setData(null);
            response.setSuccess(Boolean.FALSE);
            msg.setCodigo(401);
            msg.setDescripcion(e.getMessage());
            lMens.add(msg);
            response.setMensajes(lMens);
        }
        return response;
    }



}
