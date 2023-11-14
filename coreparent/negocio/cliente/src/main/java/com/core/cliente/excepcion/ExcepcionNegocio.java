/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.core.cliente.excepcion;

import org.springframework.http.HttpStatus;

/**
 *
 * @author tony_
 */
public class ExcepcionNegocio extends Exception {
    
    private long id;
    private String codigo;
    private HttpStatus httpStatus;

    public ExcepcionNegocio(long id, String codigo, HttpStatus httpStatus) {
        this.id = id;
        this.codigo = codigo;
        this.httpStatus = httpStatus;
    }

    public ExcepcionNegocio(String codigo, HttpStatus httpStatus) {
        this.codigo = codigo;
        this.httpStatus = httpStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
    
    

}
