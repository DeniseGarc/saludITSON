/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalTime;

/**
 *
 * @author Alici
 */
public class Horario {
    private int IDHorario;
    private LocalTime horaInicio; 
    private LocalTime horaFin;
    private int diaSemana;
    private int idMedico;
    
   //constructor vacio

    public Horario() {
    }
    
    //constructor con todos los atributos 

    public Horario(int IDHorario, LocalTime horaInicio, LocalTime horaFin, int diaSemana, int idMedico) {
        this.IDHorario = IDHorario;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.diaSemana = diaSemana;
        this.idMedico = idMedico;
    }
    
    //constructor con todos los atributos menos el IDhorario

    public Horario(LocalTime horaInicio, LocalTime horaFin, int diaSemana, int idMedico) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.diaSemana = diaSemana;
        this.idMedico = idMedico;
    }
    
    //gets y sets 

    public int getIDHorario() {
        return IDHorario;
    }

    public void setIDHorario(int IDHorario) {
        this.IDHorario = IDHorario;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }
    
    //ToString

    @Override
    public String toString() {
        return "Horario{" + "IDHorario=" + IDHorario + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", diaSemana=" + diaSemana + ", idMedico=" + idMedico + '}';
    }
    
}
