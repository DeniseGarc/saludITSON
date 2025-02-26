/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDateTime;

/**
 *
 * @author Alici
 */
public class CitaDTO {
    private String IDCita;
    private LocalDateTime fechaHora;
    private String folioCita;
    private String tipo;
    private MedicoDTO medicoDTO;
    private PacienteSimpleDTO pacienteSimpleDTO;

    public CitaDTO(String IDCita, LocalDateTime fechaHora, String folioCita, String tipo, MedicoDTO medicoDTO, PacienteSimpleDTO pacienteSimpleDTO) {
        this.IDCita = IDCita;
        this.fechaHora = fechaHora;
        this.folioCita = folioCita;
        this.tipo = tipo;
        this.medicoDTO = medicoDTO;
        this.pacienteSimpleDTO = pacienteSimpleDTO;
    }

    public String getIDCita() {
        return IDCita;
    }

    public void setIDCita(String IDCita) {
        this.IDCita = IDCita;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getFolioCita() {
        return folioCita;
    }

    public void setFolioCita(String folioCita) {
        this.folioCita = folioCita;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public MedicoDTO getMedicoDTO() {
        return medicoDTO;
    }

    public void setMedicoDTO(MedicoDTO medicoDTO) {
        this.medicoDTO = medicoDTO;
    }

    public PacienteSimpleDTO getPacienteSimpleDTO() {
        return pacienteSimpleDTO;
    }

    public void setPacienteSimpleDTO(PacienteSimpleDTO pacienteSimpleDTO) {
        this.pacienteSimpleDTO = pacienteSimpleDTO;
    }

    
    
}
