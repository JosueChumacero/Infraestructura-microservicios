/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.core.cliente.servicio;

import com.core.cliente.entidad.Cliente;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author tony_
 */
public interface ClienteServicio {
    
    List<Cliente> buscarTodo();
    Cliente guardar(Cliente cliente);
    Optional<Cliente> buscarPorId(long id);
    void eliminar(Cliente cliente);
}
