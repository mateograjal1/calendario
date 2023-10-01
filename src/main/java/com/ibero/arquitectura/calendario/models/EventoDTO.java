package com.ibero.arquitectura.calendario.models;

import java.util.Date;

import lombok.Data;

@Data
public class EventoDTO {

    private String titulo;
    private String descripcion;
    private Date fecha;
    private String lugar;
    private Long usuarioId;
    
}
