/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.core.producto.servicio.impl;


import com.core.producto.entidad.Producto;
import com.core.producto.repositorio.ProductoRepositorio;
import com.core.producto.servicio.ProductoServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tony_
 */
@Service
public class ProductoServicioImpl implements ProductoServicio{
    
    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> buscarTodo() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto guardar(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public Optional<Producto> buscarPorId(long id) {
        return productoRepositorio.findById(id);
    }

    @Override
    public void eliminar(Producto producto) {
        productoRepositorio.delete(producto);
    }
    
}
