/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entidades.Usuario;
import excepciones.PersistenciaException;

/**
 *
 * @author benjy
 */
public interface IUsuarioDAO {
    //metodo para registrar un usuario
    public Usuario registrarUsuario(Usuario usuario) throws PersistenciaException;
}
