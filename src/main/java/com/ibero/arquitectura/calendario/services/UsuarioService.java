package com.ibero.arquitectura.calendario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibero.arquitectura.calendario.models.Usuario;
import com.ibero.arquitectura.calendario.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepositorio;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepositorio.findAll();
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepositorio.findById(id).orElse(null);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepositorio.deleteById(id);
    }

    
}
