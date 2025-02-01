package com.blog.demo.model.inputDto;


public class buscaAuthorDto {
    private String nombres;
    private String paisResidencia;
    private String correo;

    public buscaAuthorDto() {
    }

    public buscaAuthorDto(String nombres, String paisResidencia, String correo) {
        this.nombres = nombres;
        this.paisResidencia = paisResidencia;
        this.correo = correo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPaisResidencia() {
        return paisResidencia;
    }

    public void setPaisResidencia(String paisResidencia) {
        this.paisResidencia = paisResidencia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
