/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.core.cliente.servicio;

import com.core.cliente.entidad.Cliente;
import com.core.cliente.excepcion.ExcepcionNegocio;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author tony_
 */
public interface ClienteServicio {
    
    List<Cliente> buscarTodo();
    public Cliente guardar(Cliente cliente) throws ExcepcionNegocio,UnknownHostException ;
    Optional<Cliente> buscarPorId(long id) throws ExcepcionNegocio, UnknownHostException;
    void eliminar(Cliente cliente);
}
