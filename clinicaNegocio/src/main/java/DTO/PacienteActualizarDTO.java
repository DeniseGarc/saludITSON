/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDate;

/**
 *
 * @author benjy
 */
public class PacienteActualizarDTO {

    private int idPaciente;
    private String nombresPaciente;
    private String apellidoPaternoPaciente;
    private String apellidoMaternoPaciente;
    private String telefono;
    private LocalDate fechaNacimiento;
    private DireccionDTO direccion;

    /**
     * Constructor con todos los atributos de un paciente para su actualización.
     * 
     * @param idPaciente El identificador único del paciente.
     * @param nombresPaciente El nombre del paciente.
     * @param apellidoPaternoPaciente El apellido paterno del paciente.
     * @param apellidoMaternoPaciente El apellido materno del paciente.
     * @param telefono El número de teléfono del paciente.
     * @param fechaNacimiento La fecha de nacimiento del paciente.
     * @param direccion La dirección del paciente.
     */
    public PacienteActualizarDTO(int idPaciente, String nombresPaciente, String apellidoPaternoPaciente, 
            String apellidoMaternoPaciente, String telefono, LocalDate fechaNacimiento, DireccionDTO direccion) {
        this.nombresPaciente = nombresPaciente;
        this.apellidoPaternoPaciente = apellidoPaternoPaciente;
        this.apellidoMaternoPaciente = apellidoMaternoPaciente;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    /**
     * Constructor vacío.
     */
    public PacienteActualizarDTO() {
    }

    /**
     * Obtiene el identificador único del paciente.
     * 
     * @return El identificador del paciente.
     */
    public int getIdPaciente() {
        return idPaciente;
    }

    /**
     * Establece el identificador único del paciente.
     * 
     * @param idPaciente El identificador del paciente.
     */
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     * Obtiene el nombre del paciente.
     * 
     * @return El nombre del paciente.
     */
    public String getNombresPaciente() {
        return nombresPaciente;
    }

    /**
     * Establece el nombre del paciente.
     * 
     * @param nombresPaciente El nombre del paciente.
     */
    public void setNombresPaciente(String nombresPaciente) {
        this.nombresPaciente = nombresPaciente;
    }

    /**
     * Obtiene el apellido paterno del paciente.
     * 
     * @return El apellido paterno del paciente.
     */
    public String getApellidoPaternoPaciente() {
        return apellidoPaternoPaciente;
    }

    /**
     * Establece el apellido paterno del paciente.
     * 
     * @param apellidoPaternoPaciente El apellido paterno del paciente.
     */
    public void setApellidoPaternoPaciente(String apellidoPaternoPaciente) {
        this.apellidoPaternoPaciente = apellidoPaternoPaciente;
    }

    /**
     * Obtiene el apellido materno del paciente.
     * 
     * @return El apellido materno del paciente.
     */
    public String getApellidoMaternoPaciente() {
        return apellidoMaternoPaciente;
    }

    /**
     * Establece el apellido materno del paciente.
     * 
     * @param apellidoMaternoPaciente El apellido materno del paciente.
     */
    public void setApellidoMaternoPaciente(String apellidoMaternoPaciente) {
        this.apellidoMaternoPaciente = apellidoMaternoPaciente;
    }

    /**
     * Obtiene el número de teléfono del paciente.
     * 
     * @return El teléfono del paciente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del paciente.
     * 
     * @param telefono El teléfono del paciente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la fecha de nacimiento del paciente.
     * 
     * @return La fecha de nacimiento del paciente.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del paciente.
     * 
     * @param fechaNacimiento La fecha de nacimiento del paciente.
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene la dirección del paciente.
     * 
     * @return La dirección del paciente.
     */
    public DireccionDTO getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del paciente.
     * 
     * @param direccion La dirección del paciente.
     */
    public void setDireccion(DireccionDTO direccion) {
        this.direccion = direccion;
    }
}