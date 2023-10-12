/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.core.transacciones.servicio.impl;


import com.core.transacciones.entidad.Transaccion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.core.transacciones.repositorio.TransaccionRepositorio;
import com.core.transacciones.servicio.TransaccionServicio;

/**
 *
 * @author tony_
 */
@Service
public class TransaccionServicioImpl implements TransaccionServicio{
    
    @Autowired
    private TransaccionRepositorio productoRepositorio;

    @Override
    public List<Transaccion> buscarTodo() {
        return productoRepositorio.findAll();
    }

    @Override
    public Transaccion guardar(Transaccion transaccion) {
        return productoRepositorio.save(transaccion);
    }

    @Override
    public Optional<Transaccion> buscarPorId(long id) {
        return productoRepositorio.findById(id);
    }

    @Override
    public void eliminar(Transaccion producto) {
        productoRepositorio.delete(producto);
    }

    @Override
    public List<Transaccion> busarPorCuenta(String cuenta) {
        return productoRepositorio.buscarPorCuenta(cuenta);
    }
    
}
