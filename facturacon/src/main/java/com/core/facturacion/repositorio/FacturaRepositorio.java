/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.core.facturacion.repositorio;

import com.core.facturacion.entidad.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author tony_
 */
public interface FacturaRepositorio extends JpaRepository<Factura, Long>{
    
}
