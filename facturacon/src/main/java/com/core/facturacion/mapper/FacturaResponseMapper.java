/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.core.facturacion.mapper;

import com.core.facturacion.dto.FacturaResponse;
import com.core.facturacion.entidad.Factura;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *
 * @author tony_
 */
@Mapper(componentModel = "spring")
public interface FacturaResponseMapper {
    
    @Mappings({
        @Mapping(source = "clienteId", target = "cliente")
    })
    FacturaResponse facturaToFacturaResponse(Factura factura);

    List<FacturaResponse> facturaListToFacturaResponseList(List<Factura> facturaList);

    @InheritInverseConfiguration
    Factura facturaResponseToFactura(FacturaResponse factura);

    @InheritInverseConfiguration
    List<Factura> facturaResponseListToFacturaList(List<FacturaResponse> facturaList);
}
