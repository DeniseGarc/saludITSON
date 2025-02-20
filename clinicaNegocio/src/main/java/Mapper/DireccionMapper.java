/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapper;

import DTO.DireccionDTO;
import entidades.Direccion;
/**
 *
 * @author Alici
 */
public class DireccionMapper {
       public Direccion ConvertirAEntidad (DireccionDTO direccionNuevo){
         Direccion direccion = new Direccion(direccionNuevo.getCalle(),direccionNuevo.getNumero(),direccionNuevo.getColonia(),direccionNuevo.getCodigoPostal());
         return direccion;
    }
    
    public DireccionDTO ConvertirADTO (Direccion direccion){
        DireccionDTO direccionNuevoDTO = new DireccionDTO(direccion.getCalle(),direccion.getNumero(),direccion.getColonia(),direccion.getCodigoPostal());
        return direccionNuevoDTO;
    } 
}
