/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.core.cliente.servicio.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.core.cliente.entidad.Cliente;
import com.core.cliente.entidad.ClienteProducto;
import com.core.cliente.repositorio.ClienteRepositorio;
import com.core.cliente.servicio.ClienteServicio;
import io.netty.channel.ChannelOption;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

/**
 *
 * @author tony_
 */
@Service
public class ClienteServicioImpl implements ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    private final WebClient.Builder webClientBuilder;

    public ClienteServicioImpl(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    HttpClient client = HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
            .option(ChannelOption.SO_KEEPALIVE, true)
            .option(EpollChannelOption.TCP_KEEPIDLE, 300)
            .option(EpollChannelOption.TCP_KEEPINTVL, 60)
            .responseTimeout(Duration.ofSeconds(1))
            .doOnConnected(connection -> {
                connection.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS));
                connection.addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS));
            });

    @Override
    public List<Cliente> buscarTodo() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public Optional<Cliente> buscarPorId(long id) {
        Optional<Cliente> cliente = clienteRepositorio.findById(id);
        if (cliente.isPresent()) {
            cliente.get().getProductos().forEach(x -> x.setNombreProducto(getProductName(x.getProductoId())));
            List<?> transacciones = getTransacciones(cliente.get().getCuenta());
            cliente.get().setTransactions(transacciones);
        }
        return cliente;
    }

    @Override
    public void eliminar(Cliente cliente) {
        clienteRepositorio.delete(cliente);
    }

    private String getProductName(long id) {

        WebClient build = webClientBuilder.clientConnector(new ReactorClientHttpConnector(client))
                .baseUrl("http://negocio-producto/producto")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "http://negocio-producto/producto"))
                .build();

        JsonNode block = build.method(HttpMethod.GET).uri("/" + id)
                .retrieve().bodyToMono(JsonNode.class).block();

        String name = block.get("nombre").asText();

        return name;
    }

    private List<?> getTransacciones(String cuenta) {
        WebClient build = webClientBuilder.clientConnector(new ReactorClientHttpConnector(client))
                .baseUrl("http://negocio-transacciones/transaccion")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        List<?> transacciones = build.method(HttpMethod.GET).uri(uriBuilder -> uriBuilder
                .path("/cliente/transacciones")
                .queryParam("cuenta", cuenta)
                .build())
                .retrieve().bodyToFlux(Object.class).collectList().block();

        return transacciones;
    }
}
