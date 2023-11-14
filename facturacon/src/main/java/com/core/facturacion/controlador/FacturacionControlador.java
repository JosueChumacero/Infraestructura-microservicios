/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.core.facturacion.controlador;

import com.core.facturacion.dto.FacturaRequest;
import com.core.facturacion.dto.FacturaResponse;
import com.core.facturacion.entidad.Factura;
import com.core.facturacion.servicio.FacturaServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author tony_
 */
@Tag(name = "Facturacion API", description = "Api solo para utilidades de facturación")
@RestController
@RequestMapping("/facturacion")
public class FacturacionControlador {
    
    @Autowired
    private FacturaServicio facturaServicio;
    
    @Operation(description = "Devuelve todas las facturas", summary = "Return 204 si no hay datos")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Exito")})
    @ApiResponse(responseCode = "500", description = "Internal Error")
    @GetMapping()
    public List<FacturaResponse> list() {
        return facturaServicio.buscarTodo();
    }
    
    @GetMapping("/{id}")
    public Factura get(@PathVariable String id) {
        return null;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<FacturaResponse> put(@PathVariable String id, @RequestBody FacturaRequest input) {
        FacturaResponse factura = facturaServicio.guardar(input);
        return ResponseEntity.ok(factura);
    }
    
    @PostMapping
    public ResponseEntity<FacturaResponse> post(@RequestBody FacturaRequest input) {
       FacturaResponse factura = facturaServicio.guardar(input);
        return ResponseEntity.ok(factura);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
    
}
