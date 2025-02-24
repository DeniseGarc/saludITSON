/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entidades.Paciente;
import excepciones.PersistenciaException;

/**
 *
 * @author benjy
 */
public interface IPacienteDAO {

    //metodo para registrar usuario
    public Paciente registrarPaciente(Paciente paciente) throws PersistenciaException;

    public boolean consultarPacientePorTelefono(String telefono) throws PersistenciaException;

    public Paciente consultarPacientePorId(int id) throws PersistenciaException;
    
   public int consultarIDPacientePorContrasenaCorreo(String correoIngresado, String contrasenaIngresada) throws PersistenciaException;
}
