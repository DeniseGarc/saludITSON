/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDate;

/**
 *
 * @author joelr
 */
public class PacienteDTO extends UsuarioDTO {
    
    private String nombresPaciente;
    private String apellidoPaternoPaciente;
    private String apellidoMaternoPaciente;
    private String correo;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String calle;
    private String numero;
    private String colonia;
    private String codigoPostal;

    /**
     * Constructor vacío de la clase PacienteDTO.
     */
    public PacienteDTO() {
    }

    /**
     * Constructor con todos los parámetros.
     * 
     * @param nombresPaciente El nombre del paciente.
     * @param apellidoPaternoPaciente El apellido paterno del paciente.
     * @param apellidoMaternoPaciente El apellido materno del paciente.
     * @param correo El correo electrónico del paciente.
     * @param telefono El número de teléfono del paciente.
     * @param fechaNacimiento La fecha de nacimiento del paciente.
     * @param calle La calle de la dirección del paciente.
     * @param numero El número de la dirección del paciente.
     * @param colonia La colonia de la dirección del paciente.
     * @param codigoPostal El código postal de la dirección del paciente.
     * @param nombreUsuario El nombre de usuario del paciente.
     * @param contrasenaUsuario La contraseña del paciente.
     */
    public PacienteDTO(String nombresPaciente, String apellidoPaternoPaciente, String apellidoMaternoPaciente, String correo, String telefono, LocalDate fechaNacimiento, String calle, String numero, String colonia, String codigoPostal, String nombreUsuario, String contrasenaUsuario) {
        super(nombreUsuario, contrasenaUsuario);
        this.nombresPaciente = nombresPaciente;
        this.apellidoPaternoPaciente = apellidoPaternoPaciente;
        this.apellidoMaternoPaciente = apellidoMaternoPaciente;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    // Getters y Setters

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
     * @param nombresPaciente El nuevo nombre del paciente.
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
     * @param apellidoPaternoPaciente El nuevo apellido paterno del paciente.
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
     * @param apellidoMaternoPaciente El nuevo apellido materno del paciente.
     */
    public void setApellidoMaternoPaciente(String apellidoMaternoPaciente) {
        this.apellidoMaternoPaciente = apellidoMaternoPaciente;
    }

    /**
     * Obtiene el correo electrónico del paciente.
     * 
     * @return El correo electrónico del paciente.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del paciente.
     * 
     * @param correo El nuevo correo electrónico del paciente.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el número de teléfono del paciente.
     * 
     * @return El número de teléfono del paciente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del paciente.
     * 
     * @param telefono El nuevo número de teléfono del paciente.
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
     * @param fechaNacimiento La nueva fecha de nacimiento del paciente.
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene la calle de la dirección del paciente.
     * 
     * @return La calle de la dirección del paciente.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle de la dirección del paciente.
     * 
     * @param calle La nueva calle de la dirección del paciente.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene el número de la dirección del paciente.
     * 
     * @return El número de la dirección del paciente.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número de la dirección del paciente.
     * 
     * @param numero El nuevo número de la dirección del paciente.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene la colonia de la dirección del paciente.
     * 
     * @return La colonia de la dirección del paciente.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia de la dirección del paciente.
     * 
     * @param colonia La nueva colonia de la dirección del paciente.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene el código postal de la dirección del paciente.
     * 
     * @return El código postal de la dirección del paciente.
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece el código postal de la dirección del paciente.
     * 
     * @param codigoPostal El nuevo código postal de la dirección del paciente.
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Devuelve una representación en formato de cadena de la clase PacienteDTO.
     * 
     * @return Una cadena con los datos del paciente.
     */
    @Override
    public String toString() {
        return "PacienteDTO{" + 
                "nombresPaciente=" + nombresPaciente + 
                ", apellidoPaternoPaciente=" + apellidoPaternoPaciente + 
                ", apellidoMaternoPaciente=" + apellidoMaternoPaciente + 
                ", correo=" + correo + 
                ", telefono=" + telefono + 
                ", fechaNacimiento=" + fechaNacimiento + 
                ", calle=" + calle + 
                ", numero=" + numero + 
                ", colonia=" + colonia + 
                ", codigoPostal=" + codigoPostal + '}';
    }
}

