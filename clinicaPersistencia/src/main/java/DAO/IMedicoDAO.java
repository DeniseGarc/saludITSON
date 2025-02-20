/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entidades.Medico;
import excepciones.PersistenciaException;

/**
 *
 * @author benjy
 */
public interface IMedicoDAO {
    //metodo para registrar un medico
   public Medico registrarMedico(Medico medico) throws PersistenciaException;
   
   

}
