package com.blog.demo.model;

public class Blog {
    private Long id;
    private String titulo;
    private String tema;
    private boolean comentarios;
    private Long idAuthor;
    private String codigoPeriodicidad;
    private Object contenido;

    public Blog() {
    }

    public Blog(String titulo, String tema, boolean comentarios, Long idAuthor, String codigoPeriodicidad, Object contenido) {
        this.titulo = titulo;
        this.tema = tema;
        this.comentarios = comentarios;
        this.idAuthor = idAuthor;
        this.codigoPeriodicidad = codigoPeriodicidad;
        this.contenido = contenido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public boolean isComentarios() {
        return comentarios;
    }

    public void setComentarios(boolean comentarios) {
        this.comentarios = comentarios;
    }

    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getCodigoPeriodicidad() {
        return codigoPeriodicidad;
    }

    public void setCodigoPeriodicidad(String codigoPeriodicidad) {
        this.codigoPeriodicidad = codigoPeriodicidad;
    }

    public Object getContenido() {
        return contenido;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }
}
