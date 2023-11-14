/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.core.cliente.servicio.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.core.cliente.entidad.Cliente;
import com.core.cliente.entidad.ClienteProducto;
import com.core.cliente.excepcion.ExcepcionNegocio;
import com.core.cliente.repositorio.ClienteRepositorio;
import com.core.cliente.rest.RestProducto;
import com.core.cliente.rest.RestTransaccion;
import com.core.cliente.servicio.ClienteServicio;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author tony_
 */
@Service
public class ClienteServicioImpl implements ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;
    @Autowired
    private RestTransaccion restTransaccion;
    @Autowired
    private RestProducto restProducto;

    @Override
    public List<Cliente> buscarTodo() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente guardar(Cliente cliente) throws ExcepcionNegocio, UnknownHostException {
        for (Iterator<ClienteProducto> iterator = cliente.getProductos().iterator(); iterator.hasNext();) {
            ClienteProducto prod = iterator.next();
            String nombreProducto;
            nombreProducto = restProducto.getProductName(prod.getProductoId());
            if (nombreProducto.isBlank()) {
                throw new ExcepcionNegocio("Error Validacion, producto no existe", HttpStatus.PRECONDITION_FAILED);
            } else {
                prod.setCliente(cliente);
            }
        }
        return clienteRepositorio.save(cliente);
    }

    @Override
    public Optional<Cliente> buscarPorId(long id) throws ExcepcionNegocio, UnknownHostException {
        Optional<Cliente> cliente = clienteRepositorio.findById(id);
        if (cliente.isPresent()) {
            for (ClienteProducto producto : cliente.get().getProductos()) {
                producto.setNombreProducto(restProducto.getProductName(producto.getProductoId()));
            }
            List<?> transacciones = restTransaccion.getTransacciones(cliente.get().getCuenta());
            cliente.get().setTransactions(transacciones);
        }
        return cliente;
    }

    @Override
    public void eliminar(Cliente cliente) {
        clienteRepositorio.delete(cliente);
    }
}
