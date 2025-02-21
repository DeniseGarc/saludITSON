/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.clinicapersistencia;

import DAO.IPacienteDAO;
import DAO.IUsuarioDAO;
import DAO.PacienteDAO;
import DAO.UsuarioDAO;
import conexion.Conexion;
import conexion.IConexion;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alici
 */
public class ClinicaPersistencia {

    public static void main(String[] args) {
        IConexion conexion = new Conexion();
        IUsuarioDAO dao = new UsuarioDAO(conexion);
        IPacienteDAO dao2 = new PacienteDAO(conexion);
        try {
                System.out.println(dao2.consultarPacientePorTelefono("0"));
        } catch (PersistenciaException ex) {
            Logger.getLogger(ClinicaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
