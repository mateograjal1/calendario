package com.ibero.arquitectura.calendario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibero.arquitectura.calendario.models.Evento;
import com.ibero.arquitectura.calendario.models.Usuario;
import com.ibero.arquitectura.calendario.repository.EventoRepository;

@Service
public class EventoService {
    
private final EventoRepository eventoRepositorio;

    @Autowired
    public EventoService(EventoRepository eventoRepositorio) {
        this.eventoRepositorio = eventoRepositorio;
    }

    public List<Evento> obtenerTodosEventos() {
        return eventoRepositorio.findAll();
    }

    public List<Evento> obtenerTodosEventosPorUsuario(Usuario usuario) {
        return eventoRepositorio.findByUsuario(usuario);
    }

    public Evento guardarEvento(Evento evento) {
        return eventoRepositorio.save(evento);
    }

    public Evento obtenerEventoPorId(Long id) {
        return eventoRepositorio.findById(id).orElse(null);
    }

    public void eliminarEvento(Long id) {
        eventoRepositorio.deleteById(id);
    }

}
