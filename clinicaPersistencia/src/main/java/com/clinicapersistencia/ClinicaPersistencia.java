/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.clinicapersistencia;

import DAO.CitaDAO;
import DAO.ICitaDAO;
import DAO.IMedicoDAO;
import DAO.MedicoDAO;
import conexion.Conexion;
import conexion.IConexion;
import entidades.Medico;
import entidades.Paciente;
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
        ICitaDAO dao = new CitaDAO(conexion);
                IMedicoDAO dao2 = new MedicoDAO(conexion);

        Medico medico = new Medico(4, null, null, null, null, null, null, null, null);
        Paciente paciente = new Paciente(1, null, null, null, null, null, null, null, null);
        try {
//            System.out.println(dao.agendarCita(LocalDateTime.of(2025, Month.MARCH, 04, 15, 00), medico, paciente));
//            List<LocalTime> horariosDisponibles = dao.obtenerHorariosCitas(medico, LocalDateTime.of(2025, Month.MARCH, 04));
//            System.out.println(horariosDisponibles);
            System.out.println(dao2.consultarMedicosPorEspecialidad("CARDIoloGIA"));
        } catch (PersistenciaException ex) {
            Logger.getLogger(ClinicaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
