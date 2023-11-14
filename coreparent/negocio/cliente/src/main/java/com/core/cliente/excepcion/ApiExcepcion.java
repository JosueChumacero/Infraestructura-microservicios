/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.core.cliente.excepcion;

import com.core.cliente.util.EstandarApiExcepcionResponse;
import java.io.IOException;
import java.net.UnknownHostException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author tony_
 */
@RestControllerAdvice
public class ApiExcepcion {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<EstandarApiExcepcionResponse> excepcionGenerica(Exception ex){
        EstandarApiExcepcionResponse response = new EstandarApiExcepcionResponse("Error Inesperado","erorr-9999",ex.getMessage());
        return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(UnknownHostException.class)
    public ResponseEntity<EstandarApiExcepcionResponse> hostException(UnknownHostException ex){
        EstandarApiExcepcionResponse response = new EstandarApiExcepcionResponse("Error en conexion","erorr-1",ex.getMessage());
        return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(ExcepcionNegocio.class)
    public ResponseEntity<EstandarApiExcepcionResponse> excepcionNegocop(ExcepcionNegocio ex){
        EstandarApiExcepcionResponse response = new EstandarApiExcepcionResponse("Error Validacion",ex.getCodigo(),ex.getMessage());
        return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
