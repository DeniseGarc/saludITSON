/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.CitaDAO;
import DAO.ICitaDAO;
import DAO.IMedicoDAO;
import DAO.MedicoDAO;
import DTO.CitaDTO;
import conexion.IConexion;
import mapper.MedicoMapper;

/**
 *
 * @author Alici
 */
public class CitaBO {

    private final ICitaDAO citaDAO;
    private final IMedicoDAO medicoDAO;
    private final MedicoMapper mapper = new MedicoMapper();

    public CitaBO(IConexion conexion) {
        this.citaDAO = new CitaDAO(conexion);
        this.medicoDAO = new MedicoDAO(conexion);
    }

    //public List<String> 
    
//    public boolean agendarCita(CitaDTO citaDTO){
//        
//    }
    
}
