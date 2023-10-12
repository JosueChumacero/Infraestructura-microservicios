/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.core.cliente.repositorio;

import com.core.cliente.entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author tony_
 */
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    
}
