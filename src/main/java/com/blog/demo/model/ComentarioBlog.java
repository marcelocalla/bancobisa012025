package com.blog.demo.model;

public class ComentarioBlog {
    private Long id;
    private String comentario;
    private Long idAuthor;
    private Long idBlog;
    private Integer puntuacion;


    public ComentarioBlog() {
    }

    public ComentarioBlog(String comentario, Long idAuthor, Long idBlog, Integer puntuacion) {
        this.comentario = comentario;
        this.idAuthor = idAuthor;
        this.idBlog = idBlog;
        this.puntuacion = puntuacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public Long getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Long idBlog) {
        this.idBlog = idBlog;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }
}
