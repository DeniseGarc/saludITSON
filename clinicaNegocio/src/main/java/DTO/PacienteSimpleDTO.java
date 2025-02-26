/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Alici
 */
public class PacienteSimpleDTO {

    private String IDPaciente;
    private String nombrePaciente;
    private String apellidoPaternoPaciente;
    private String apellidoMaternoPaciente;
    private String edad;

    /**
     * Constructor con todos los atributos del paciente.
     * 
     * @param IDPaciente El ID del paciente.
     * @param nombrePaciente El nombre del paciente.
     * @param apellidoPaternoPaciente El apellido paterno del paciente.
     * @param apellidoMaternoPaciente El apellido materno del paciente.
     * @param edad La edad del paciente.
     */
    public PacienteSimpleDTO(String IDPaciente, String nombrePaciente, String apellidoPaternoPaciente, 
                             String apellidoMaternoPaciente, String edad) {
        this.IDPaciente = IDPaciente;
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaternoPaciente = apellidoPaternoPaciente;
        this.apellidoMaternoPaciente = apellidoMaternoPaciente;
        this.edad = edad;
    }



    /**
     * Obtiene el ID del paciente.
     * 
     * @return El ID del paciente.
     */
    public String getIDPaciente() {
        return IDPaciente;
    }

    /**
     * Establece el ID del paciente.
     * 
     * @param IDPaciente El ID del paciente.
     */
    public void setIDPaciente(String IDPaciente) {
        this.IDPaciente = IDPaciente;
    }

    /**
     * Obtiene el nombre del paciente.
     * 
     * @return El nombre del paciente.
     */
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    /**
     * Establece el nombre del paciente.
     * 
     * @param nombrePaciente El nombre del paciente.
     */
    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
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
     * Obtiene la edad del paciente.
     * 
     * @return La edad del paciente.
     */
    public String getEdad() {
        return edad;
    }

    /**
     * Establece la edad del paciente.
     * 
     * @param edad La edad del paciente.
     */
    public void setEdad(String edad) {
        this.edad = edad;
    }

    /**
     * Devuelve una representación en cadena del nombre completo del paciente.
     * 
     * @return Una cadena que representa el nombre completo del paciente.
     */
    @Override
    public String toString() {
        return nombrePaciente + " " + apellidoPaternoPaciente + " " + apellidoMaternoPaciente;
    }
}
