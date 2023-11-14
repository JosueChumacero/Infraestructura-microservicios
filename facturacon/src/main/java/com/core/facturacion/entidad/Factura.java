/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.core.facturacion.entidad;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author tony_
 */
@Entity
@Data
@Schema(name = "Factura", description = "modelo que representa a factura en la base de datos")
public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long clienteId;
    private String numero;
    private String detail;
    private double monto;
}
