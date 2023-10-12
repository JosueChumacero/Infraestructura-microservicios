/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.core.producto.servicio;

import com.core.producto.entidad.Producto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author tony_
 */
public interface ProductoServicio {
    
    List<Producto> buscarTodo();
    Producto guardar(Producto producto);
    Optional<Producto> buscarPorId(long id);
    void eliminar(Producto producto);
}
