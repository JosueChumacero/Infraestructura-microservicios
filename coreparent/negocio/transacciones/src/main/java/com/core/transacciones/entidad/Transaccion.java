/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.core.transacciones.entidad;

import java.time.LocalDateTime;
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
public class Transaccion {
    
    @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
   private long id;
   private String referencia;
   private String cuenta;
   private LocalDateTime fecha;
   private double monto ;
   private double comision;   
   private String descripcion;
   private String estado;
   private String canal;  
}
