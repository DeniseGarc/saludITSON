/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entidades.Paciente;
import excepciones.PersistenciaException;
import java.time.LocalDate;

/**
 *
 * @author benjy
 */
public interface IPacienteDAO {

    //metodo para registrar usuario
    public Paciente registrarPaciente(Paciente paciente) throws PersistenciaException;

    public boolean consultarPacientePorTelefono(String telefono) throws PersistenciaException;
    
    public String consultarNombreCompletoPaciente(int idPaciente) throws PersistenciaException;
       
  public boolean actualizarPaciente(int idPaciente, String nombres, String apellidoPaterno, String apellidoMaterno,
  String telefono, LocalDate fechaNacimiento,int idDireccion, String calle, String numero, String colonia, String codigoPostal) throws PersistenciaException; 
  
  public boolean tieneCitasActivas(int idPaciente) throws PersistenciaException;
  
  public int obtenerIdDireccionPorPaciente(int idPaciente) throws PersistenciaException;
  
  public Paciente obtenerDatosPaciente(int idPaciente) throws PersistenciaException;
}
