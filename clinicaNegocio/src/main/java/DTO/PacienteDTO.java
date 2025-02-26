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
     * Constructor vacío.
     */
    public PacienteDTO() {
    }

    /**
     * Constructor con todos los atributos de un paciente.
     * 
     * @param nombresPaciente El nombre del paciente.
     * @param apellidoPaternoPaciente El apellido paterno del paciente.
     * @param apellidoMaternoPaciente El apellido materno del paciente.
     * @param correo El correo electrónico del paciente.
     * @param telefono El número de teléfono del paciente.
     * @param fechaNacimiento La fecha de nacimiento del paciente.
     * @param calle La calle donde vive el paciente.
     * @param numero El número de la casa o departamento.
     * @param colonia La colonia del paciente.
     * @param codigoPostal El código postal del paciente.
     * @param nombreUsuario El nombre de usuario del paciente.
     * @param contrasenaUsuario La contraseña del paciente.
     */
    public PacienteDTO(String nombresPaciente, String apellidoPaternoPaciente, String apellidoMaternoPaciente, 
                       String correo, String telefono, LocalDate fechaNacimiento, 
                       String calle, String numero, String colonia, String codigoPostal, 
                       String nombreUsuario, String contrasenaUsuario) {
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

    // Métodos get y set para los atributos

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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Devuelve una representación en cadena de los atributos del paciente.
     * 
     * @return Una cadena que representa los atributos del paciente.
     */
    @Override
    public String toString() {
        return "PacienteDTO{" +"nombresPaciente=" + nombresPaciente + ", apellidoPaternoPaciente=" + apellidoPaternoPaciente + ", apellidoMaternoPaciente=" + apellidoMaternoPaciente +", correo=" + correo + ", telefono=" + telefono +", fechaNacimiento=" + fechaNacimiento + ", calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + ", codigoPostal=" + codigoPostal + '}';
    }
}