/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.core.facturacion.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 *
 * @author tony_
 */
@Data
@Schema(name = "FacturaRequest", description = "modelo que representa a factura")
public class FacturaRequest {
    @Schema(name = "cliente", required = true, example = "2",defaultValue = "1", description = "clave unica que representa el dueño de la factura")
    private long cliente;
    @Schema(name = "numero", required = true, example = "2",defaultValue = "1", description = "numero de factura")
    private String numero;
    private String detail;
    private double monto;
}
