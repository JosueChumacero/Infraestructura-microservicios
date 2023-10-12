/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.core.transacciones.servicio;

import com.core.transacciones.entidad.Transaccion;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author tony_
 */
public interface TransaccionServicio {
    
    List<Transaccion> buscarTodo();
    Transaccion guardar(Transaccion transaccion);
    Optional<Transaccion> buscarPorId(long id);
    void eliminar(Transaccion producto);
    List<Transaccion> busarPorCuenta(String cuenta);
}
