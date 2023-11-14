/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.core.facturacion.mapper;

import com.core.facturacion.dto.FacturaRequest;
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
public interface FacturaRequestMapper {

    @Mappings({
        @Mapping(source = "cliente", target = "clienteId")
    })
    Factura facturaResquetToFactura(FacturaRequest factura);

    List<Factura> facturaResquetListToFacturaList(List<FacturaRequest> facturaList);

    @InheritInverseConfiguration
    FacturaRequest facturaToFacturaResquet(Factura factura);

    @InheritInverseConfiguration
    List<FacturaRequest> facturaListToFacturaResquetList(List<Factura> facturaList);
}
