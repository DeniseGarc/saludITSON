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
    private Medico medico;
    private Paciente paciente;
    //constructor vacio
    public Cita() {
    }

    public Cita(int IDCita, LocalDate fechaHora, String estadoCita, String folioCita, String tipo, Medico medico, Paciente paciente) {
        this.IDCita = IDCita;
        this.fechaHora = fechaHora;
        this.estadoCita = estadoCita;
        this.folioCita = folioCita;
        this.tipo = tipo;
        this.medico = medico;
        this.paciente = paciente;
    }

    public Cita(LocalDate fechaHora, String estadoCita, String folioCita, String tipo, Medico medico, Paciente paciente) {
        this.fechaHora = fechaHora;
        this.estadoCita = estadoCita;
        this.folioCita = folioCita;
        this.tipo = tipo;
        this.medico = medico;
        this.paciente = paciente;
    }

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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Cita{" + "IDCita=" + IDCita + ", fechaHora=" + fechaHora + ", estadoCita=" + estadoCita + ", folioCita=" + folioCita + ", tipo=" + tipo + ", medico=" + medico + ", paciente=" + paciente + '}';
    }


    
    
}
