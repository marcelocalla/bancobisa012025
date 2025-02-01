package com.blog.demo.util;

import java.util.ArrayList;
import java.util.List;

public class ResponseServices {
    private Boolean success;
    private List<MensajeServices> mensajes = new ArrayList();

    public ResponseServices() {
    }

    public ResponseServices(Boolean success, List<MensajeServices> mensajes) {
        this.success = success;
        this.mensajes = mensajes;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<MensajeServices> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<MensajeServices> mensajes) {
        this.mensajes = mensajes;
    }
}
