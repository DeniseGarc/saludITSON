/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import entidades.Direccion;
import java.time.LocalDate;

/**
 *
 * @author joelr
 */
public class PacienteDTO extends UsuarioDTO{
    
    private String nombresPaciente;
    private String apellidoPaternoPaciente; 
    private String apellidoMaternoPaciente;
    private String correo;
    private String telefono;
    private LocalDate fechaNacimiento; 
    private Direccion direccion;

    //Constructor vacio.
    public PacienteDTO() {
    }
    
    //Constructor con atributos.

    public PacienteDTO(String nombresPaciente, String apellidoPaternoPaciente, String apellidoMaternoPaciente, String correo, String telefono, LocalDate fechaNacimiento, Direccion direccion) {
        this.nombresPaciente = nombresPaciente;
        this.apellidoPaternoPaciente = apellidoPaternoPaciente;
        this.apellidoMaternoPaciente = apellidoMaternoPaciente;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }


    //gets y sets
    public String getNombresPaciente() {
        return nombresPaciente;
    }

    public void setNombresPaciente(String nombresPaciente) {
        this.nombresPaciente = nombresPaciente;
    }

    public String getApellidoPaternoPaciente() {
        return apellidoPaternoPaciente;
    }

    public void setApellidoPaternoPaciente(String apellidoPaternoPaciente) {
        this.apellidoPaternoPaciente = apellidoPaternoPaciente;
    }

    public String getApellidoMaternoPaciente() {
        return apellidoMaternoPaciente;
    }

    public void setApellidoMaternoPaciente(String apellidoMaternoPaciente) {
        this.apellidoMaternoPaciente = apellidoMaternoPaciente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
 
    //toString 

    @Override
    public String toString() {
        return "Paciente: " + ", nombresPaciente=" + nombresPaciente + ", apellidoPaternoPaciente=" + apellidoPaternoPaciente + ", apellidoMaternoPaciente=" + apellidoMaternoPaciente + ", correo=" + correo + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + '}';
    }

}
