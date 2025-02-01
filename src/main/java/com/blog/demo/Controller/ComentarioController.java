package com.blog.demo.Controller;

import com.blog.demo.model.inputDto.inputComentarioDto;
import com.blog.demo.services.AuthorService;
import com.blog.demo.services.BlogService;
import com.blog.demo.services.ComentarioService;
import com.blog.demo.util.GenericResponse;
import com.blog.demo.util.MensajeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/com")
public class ComentarioController {
    @Autowired
    private AuthorService service;

    @Autowired
    private BlogService serviceBlog;

    @Autowired
    private ComentarioService serviceComent;

    /**
     * Crea un comentario para el blog
     * @param pInput
     * @return
     */

    @PostMapping(path = "/createComentario", consumes = "application/json")
    public GenericResponse<inputComentarioDto> creaBlog(@RequestBody inputComentarioDto pInput) {
        GenericResponse<inputComentarioDto> response = new GenericResponse<>();
        MensajeServices msg= new MensajeServices();
        List<MensajeServices> lMens = new ArrayList<>();
        try{
            var repon=serviceComent.saveComentarioGral(pInput);
            if(repon == null){
                response.setData(null);
                response.setSuccess(Boolean.FALSE);
                msg.setCodigo(400);
                msg.setDescripcion("Existe errores!");
            }else {
                response.setData(repon);
                response.setSuccess(Boolean.TRUE);
                msg.setCodigo(200);
                msg.setDescripcion("Se registro correctamente el comentario");
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

    /**
     * Actualiza la informacion de los comentarios por el id
     * @param pInput
     * @param id
     * @return
     */

    @PostMapping(path = "/editComentario/{id}", consumes = "application/json")
    public GenericResponse<inputComentarioDto> actualizaBlog(@RequestBody inputComentarioDto pInput, @PathVariable(name="id") Long id) {
        GenericResponse<inputComentarioDto> response = new GenericResponse<>();
        MensajeServices msg= new MensajeServices();
        List<MensajeServices> lMens = new ArrayList<>();
        try{
            var repon=serviceComent.updateComentarioGral(pInput, id);
            if(repon == null){
                response.setData(null);
                response.setSuccess(Boolean.FALSE);
                msg.setCodigo(400);
                msg.setDescripcion("Existe errores!");
            }else {
                response.setData(repon);
                response.setSuccess(Boolean.TRUE);
                msg.setCodigo(200);
                msg.setDescripcion("Se registro correctamente el comentario");
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
