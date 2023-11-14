/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.core.facturacion.servicio.impl;

import com.core.facturacion.dto.FacturaRequest;
import com.core.facturacion.dto.FacturaResponse;
import com.core.facturacion.entidad.Factura;
import com.core.facturacion.mapper.FacturaRequestMapper;
import com.core.facturacion.mapper.FacturaResponseMapper;
import com.core.facturacion.repositorio.FacturaRepositorio;
import com.core.facturacion.servicio.FacturaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tony_
 */
@Service
public class FacturaServicioImpl implements FacturaServicio {
    
    @Autowired
    private FacturaRepositorio facturaRepositorio;
    
    @Autowired
    private FacturaResponseMapper facturaResponseMapper;
    
    @Autowired
    private FacturaRequestMapper facturaRequestMapper;
    
    @Override
    public List<FacturaResponse> buscarTodo() {
        List<Factura> listaFactura = facturaRepositorio.findAll();
        List<FacturaResponse> listaFacturaResponse = facturaResponseMapper.facturaListToFacturaResponseList(listaFactura);
        return listaFacturaResponse;
    }
    
    @Override
    public FacturaResponse guardar(FacturaRequest facturaRequest) {
        Factura factura = facturaRequestMapper.facturaResquetToFactura(facturaRequest);
        return facturaResponseMapper.facturaToFacturaResponse(facturaRepositorio.save(factura));
    }
    
}
