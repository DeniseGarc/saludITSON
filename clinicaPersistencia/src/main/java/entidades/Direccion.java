/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Alici
 */
public class Direccion {
    private int IDDireccion;
    private String calle;
    private String numero;
    private String colonia;
    private String codigoPostal;
    
    //constructor vacio

    public Direccion() {
    }
    
    //constructor con todos los atributos 

    public Direccion(int IDDireccion, String calle, String numero, String colonia, String codigoPostal) {
        this.IDDireccion = IDDireccion;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }
    
    //constructor con todos los atributos menos IDDireccion

    public Direccion(String calle, String numero, String colonia, String codigoPostal) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }
    
    //Sets y sets 

    public int getIDDireccion() {
        return IDDireccion;
    }

    public void setIDDireccion(int IDDireccion) {
        this.IDDireccion = IDDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
    //toString

    @Override
    public String toString() {
        return "Direccion{" + "IDDireccion=" + IDDireccion + ", calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + ", codigoPostal=" + codigoPostal + '}';
    }
    
}
