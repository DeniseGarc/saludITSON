/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Pruebas;

import BO.PacienteBO;
import DTO.PacienteDTO;
import conexion.Conexion;
import conexion.IConexion;
import entidades.Direccion;
import excepciones.NegocioException;
import java.time.LocalDate;

/**
 *
 * @author joelr
 */
public class ClinicaNegocio {

    static LocalDate fecha = LocalDate.parse("2011-06-12");
    static Direccion direccion = new Direccion("asdsfa", "aasad", "sads", "as1ff");

    public static void main(String[] args) throws NegocioException {
//        IConexion conexion = new Conexion();
////        PacienteDTO pacienteVacio = new PacienteDTO();
////        PacienteDTO paciente1 = new PacienteDTO("Metro2", "Mitro2", "Matro2", "Memimatro3@gmail.com", "643233345", fecha, direccion);
////        paciente1.setContrasenaUsuario("potrobes");
//        PacienteBO pabo = new PacienteBO(conexion);
////        pabo.RegistrarPaciente(pacienteVacio);
//        try {
//            pabo.RegistrarPaciente(paciente1);
//
//        } catch (NegocioException e) {
//            System.out.println("error");
//        }
    }
}
