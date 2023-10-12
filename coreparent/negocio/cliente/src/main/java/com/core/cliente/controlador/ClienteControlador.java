/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.core.cliente.controlador;

import com.core.cliente.entidad.Cliente;
import com.core.cliente.servicio.ClienteServicio;
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
@RequestMapping("/cliente")
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;
    
    @Value("${user.role}")
    private  String rol;
    
    @GetMapping("/rol")
    public String rol(){
        return rol;
    }

    @GetMapping()
    public List<Cliente> buscarTodo() {
        return clienteServicio.buscarTodo();
    }

    @GetMapping("/{id}")
    public Cliente get(@PathVariable long id) {
        return clienteServicio.buscarPorId(id).get();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable long id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteBase = clienteServicio.buscarPorId(id);
        if (clienteBase.isPresent()) {
            clienteBase.get().setApellidos(cliente.getApellidos() != null ? cliente.getApellidos() : clienteBase.get().getApellidos());
            clienteBase.get().setCuenta(cliente.getCuenta() != null ? cliente.getCuenta() : clienteBase.get().getCuenta());
            clienteBase.get().setEmail(cliente.getEmail() != null ? cliente.getEmail() : clienteBase.get().getEmail());
            clienteBase.get().setTelefono(cliente.getTelefono() != null ? cliente.getTelefono() : clienteBase.get().getTelefono());
            clienteBase.get().setNombre(cliente.getNombre() != null ? cliente.getNombre() : clienteBase.get().getNombre());
            return ResponseEntity.ok(clienteServicio.guardar(clienteBase.get()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PostMapping
    public ResponseEntity<Cliente> post(@RequestBody Cliente cliente) {
        cliente.getProductos().forEach(x -> x.setCliente(cliente));
        Cliente clienteBase = clienteServicio.guardar(cliente);
        return ResponseEntity.ok(clienteBase);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        Optional<Cliente> cliente = clienteServicio.buscarPorId(id);
        if (cliente.isPresent()) {
            clienteServicio.eliminar(cliente.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
