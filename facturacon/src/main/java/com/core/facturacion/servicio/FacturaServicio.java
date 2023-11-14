/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.core.facturacion.servicio;

import com.core.facturacion.dto.FacturaRequest;
import com.core.facturacion.dto.FacturaResponse;
import com.core.facturacion.entidad.Factura;
import java.util.List;

/**
 *
 * @author tony_
 */
public interface FacturaServicio {
    
    List<FacturaResponse> buscarTodo();
    
    FacturaResponse guardar(FacturaRequest factura);
}
