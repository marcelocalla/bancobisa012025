package com.blog.demo.model;

public class TipoPeriodicidad {
    private String codigo;
    private String Descripcion;

    public TipoPeriodicidad() {
    }

    public TipoPeriodicidad(String codigo, String descripcion) {
        this.codigo = codigo;
        Descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
