package com.blog.demo.model.inputDto;

import com.blog.demo.model.ComentarioBlog;

public class inputComentarioDto {
    private buscaAuthorDto auth;
    private String tituloBlog;
    private ComentarioBlog comentario;

    public inputComentarioDto() {
    }

    public inputComentarioDto(buscaAuthorDto auth, String tituloBlog, ComentarioBlog comentario) {
        this.auth = auth;
        this.tituloBlog = tituloBlog;
        this.comentario = comentario;
    }

    public buscaAuthorDto getAuth() {
        return auth;
    }

    public void setAuth(buscaAuthorDto auth) {
        this.auth = auth;
    }

    public String getTituloBlog() {
        return tituloBlog;
    }

    public void setTituloBlog(String tituloBlog) {
        this.tituloBlog = tituloBlog;
    }

    public ComentarioBlog getComentario() {
        return comentario;
    }

    public void setComentario(ComentarioBlog comentario) {
        this.comentario = comentario;
    }
}
