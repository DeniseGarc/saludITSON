/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDate;

/**
 *
 * @author Alici
 */
public class Cita {
    private int IDCita;
    private LocalDate fechaHora;
    private String estadoCita;
    private String folioCita;
    private String tipo;
    private int idMedico;
    private int idPaciente;
    //constructor vacio
    public Cita() {
    }
    //Constructor con todos Los atributos

    public Cita(int IDCita, LocalDate fechaHora, String estadoCita, String folioCita, String tipo, int idMedico, int idPaciente) {
        this.IDCita = IDCita;
        this.fechaHora = fechaHora;
        this.estadoCita = estadoCita;
        this.folioCita = folioCita;
        this.tipo = tipo;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
    }
    //Constructor con todo menos IDCita
    public Cita(LocalDate fechaHora, String estadoCita, String folioCita, String tipo, int idMedico, int idPaciente) {
        this.fechaHora = fechaHora;
        this.estadoCita = estadoCita;
        this.folioCita = folioCita;
        this.tipo = tipo;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
    }
    
    //gets y sets 

    public int getIDCita() {
        return IDCita;
    }

    public void setIDCita(int IDCita) {
        this.IDCita = IDCita;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
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

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    
    //toString 

    @Override
    public String toString() {
        return "Cita{" + "IDCita=" + IDCita + ", fechaHora=" + fechaHora + ", estadoCita=" + estadoCita + ", folioCita=" + folioCita + ", tipo=" + tipo + ", idMedico=" + idMedico + ", idPaciente=" + idPaciente + '}';
    }
}
