package com.ibero.arquitectura.calendario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibero.arquitectura.calendario.models.Evento;
import com.ibero.arquitectura.calendario.models.Usuario;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{

    public List<Evento> findByUsuario(Usuario user);
    
}
