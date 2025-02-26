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
public class CitaEmergenciaDTO {

    private String idCita;
    private LocalDateTime fechaHora;
    private String folioCita;
    private MedicoDTO medicoDTO;
    private String idPaciente;

    public CitaEmergenciaDTO(String idCita, LocalDateTime fechaHora, String folioCita, MedicoDTO medicoDTO, String idPaciente) {
        this.idCita = idCita;
        this.fechaHora = fechaHora;
        this.folioCita = folioCita;
        this.medicoDTO = medicoDTO;
        this.idPaciente = idPaciente;
    }

    public CitaEmergenciaDTO(LocalDateTime fechaHora, String folioCita, MedicoDTO medicoDTO, String idPaciente) {
        this.fechaHora = fechaHora;
        this.folioCita = folioCita;
        this.medicoDTO = medicoDTO;
        this.idPaciente = idPaciente;
    }

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
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

    public MedicoDTO getMedicoDTO() {
        return medicoDTO;
    }

    public void setMedicoDTO(MedicoDTO medicoDTO) {
        this.medicoDTO = medicoDTO;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

}
