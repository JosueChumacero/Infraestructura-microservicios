/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.core.transacciones.controlador;

import com.core.transacciones.entidad.Transaccion;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.core.transacciones.servicio.TransaccionServicio;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author tony_
 */
@RestController
@RequestMapping("/transaccion")
public class TransaccionControlador {

    @Autowired
    private TransaccionServicio transaccionServicio;
    
    @Value("${user.role}")
    private  String rol;
    
    @GetMapping("/rol")
    public String rol(){
        return rol;
    }

    @GetMapping()
    public List<Transaccion> list() {
        return transaccionServicio.buscarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaccion> get(@PathVariable long id) {
        return transaccionServicio.buscarPorId(id).map(x -> ResponseEntity.ok(x)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cliente/transacciones")
    public List<Transaccion> get(@RequestParam String cuenta) {
        return transaccionServicio.busarPorCuenta(cuenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable long id, @RequestBody Transaccion transaccion) {
        Transaccion find = transaccionServicio.buscarPorId(id).get();
        if (find != null) {
            find.setMonto(transaccion.getMonto());
            find.setCanal(transaccion.getCanal());
            find.setFecha(transaccion.getFecha());
            find.setDescripcion(transaccion.getDescripcion());
            find.setComision(transaccion.getComision());
            find.setCuenta(transaccion.getCuenta());
            find.setReferencia(transaccion.getReferencia());
            find.setEstado(transaccion.getEstado());
        }
        Transaccion save = transaccionServicio.guardar(find);
        return ResponseEntity.ok(save);
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Transaccion transaccion) {
        Transaccion save = transaccionServicio.guardar(transaccion);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        Optional<Transaccion> findById = transaccionServicio.buscarPorId(id);
        if (findById.get() != null) {
            transaccionServicio.eliminar(findById.get());
        }
        return ResponseEntity.ok().build();
    }
}
