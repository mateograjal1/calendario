package com.ibero.arquitectura.calendario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibero.arquitectura.calendario.models.Evento;
import com.ibero.arquitectura.calendario.models.EventoDTO;
import com.ibero.arquitectura.calendario.models.Usuario;
import com.ibero.arquitectura.calendario.services.EventoService;
import com.ibero.arquitectura.calendario.services.UsuarioService;

@RestController
@RequestMapping("/api/eventos")
@CrossOrigin
public class EventoController {

    private final EventoService eventoService;

    private final UsuarioService usuarioService;

    @Autowired
    public EventoController(EventoService eventoService, UsuarioService usuarioService) {
        this.eventoService = eventoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Evento> obtenerTodosEventos() {
        return eventoService.obtenerTodosEventos();
    }

    @GetMapping("/usuario/{id}")
    public List<Evento> obtenerTodosEventosDeUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        System.out.println("Obteniendo todos los eventos de usuario: " + usuario.getNombre());
        return eventoService.obtenerTodosEventosPorUsuario(usuario);
    }

    @PostMapping
    public Evento crearEvento(@RequestBody EventoDTO evento) {
        Evento e = new Evento();
        e.setTitulo(evento.getTitulo());
        e.setDescripcion(evento.getDescripcion());
        e.setFecha(evento.getFecha());
        e.setLugar(evento.getLugar());
        e.setUsuario(usuarioService.obtenerUsuarioPorId(evento.getUsuarioId()));
        return eventoService.guardarEvento(e);
    }

    @GetMapping("/{id}")
    public Evento obtenerEventoPorId(@PathVariable Long id) {
        return eventoService.obtenerEventoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarEvento(@PathVariable Long id) {
        eventoService.eliminarEvento(id);
    }
    
}
