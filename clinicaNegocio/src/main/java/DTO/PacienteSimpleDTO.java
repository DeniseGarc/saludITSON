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

    public PacienteSimpleDTO(String IDPaciente, String nombrePaciente, String apellidoPaternoPaciente, String apellidoMaternoPaciente, String edad) {
        this.IDPaciente = IDPaciente;
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaternoPaciente = apellidoPaternoPaciente;
        this.apellidoMaternoPaciente = apellidoMaternoPaciente;
        this.edad = edad;
    }

    public String getIDPaciente() {
        return IDPaciente;
    }

    public void setIDPaciente(String IDPaciente) {
        this.IDPaciente = IDPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombrePaciente + " "
                + apellidoPaternoPaciente + " "
                + apellidoMaternoPaciente;
    }
}
