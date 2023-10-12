/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.core.producto.controlador;

import com.core.producto.entidad.Producto;
import com.core.producto.servicio.ProductoServicio;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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
@RestController
@RequestMapping("/producto")
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;
    
    @Value("${user.role}")
    private  String rol;
    
    @GetMapping("/rol")
    public String rol(){
        return rol;
    }

    @GetMapping()
    public List<Producto> buscarTodo() {
        return productoServicio.buscarTodo();
    }

    @GetMapping("/{id}")
    public Object get(@PathVariable long id) {
        return productoServicio.buscarPorId(id).get();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable long id, @RequestBody Producto producto) {
        Optional<Producto> productoBase = productoServicio.buscarPorId(id);
        if (productoBase.isPresent()) {
            productoBase.get().setCodigo(producto.getCodigo() != null ? producto.getCodigo() : productoBase.get().getCodigo());
            productoBase.get().setNombre(producto.getNombre() != null ? producto.getNombre() : productoBase.get().getNombre());
            return ResponseEntity.ok(productoServicio.guardar(productoBase.get()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Producto> post(@RequestBody Producto producto) {
        Producto clienteBase = productoServicio.guardar(producto);
        return ResponseEntity.ok(clienteBase);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        Optional<Producto> producto = productoServicio.buscarPorId(id);
        if (producto.isPresent()) {
            productoServicio.eliminar(producto.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
