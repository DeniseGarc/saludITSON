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

    /**
     * Constructor vacío.
     */
    public Direccion() {
    }

    /**
     * Constructor con todos los atributos de la dirección.
     * 
     * @param IDDireccion Identificador de la dirección
     * @param calle Calle de la dirección
     * @param numero Número de la dirección
     * @param colonia Colonia de la dirección
     * @param codigoPostal Código postal de la dirección
     */
    public Direccion(int IDDireccion, String calle, String numero, String colonia, String codigoPostal) {
        this.IDDireccion = IDDireccion;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Constructor sin IDDireccion.
     * 
     * @param calle Calle de la dirección
     * @param numero Número de la dirección
     * @param colonia Colonia de la dirección
     * @param codigoPostal Código postal de la dirección
     */
    public Direccion(String calle, String numero, String colonia, String codigoPostal) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }


    /**
     * Obtiene el identificador de la dirección.
     * 
     * @return El identificador de la dirección.
     */
    public int getIDDireccion() {
        return IDDireccion;
    }

    /**
     * Establece el identificador de la dirección.
     * 
     * @param IDDireccion El nuevo identificador de la dirección.
     */
    public void setIDDireccion(int IDDireccion) {
        this.IDDireccion = IDDireccion;
    }

    /**
     * Obtiene la calle de la dirección.
     * 
     * @return La calle de la dirección.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle de la dirección.
     * 
     * @param calle La nueva calle.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene el número de la dirección.
     * 
     * @return El número de la dirección.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número de la dirección.
     * 
     * @param numero El nuevo número de la dirección.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene la colonia de la dirección.
     * 
     * @return La colonia de la dirección.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia de la dirección.
     * 
     * @param colonia La nueva colonia.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene el código postal de la dirección.
     * 
     * @return El código postal de la dirección.
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece el código postal de la dirección.
     * 
     * @param codigoPostal El nuevo código postal.
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Devuelve una representación en cadena de la dirección.
     * 
     * @return La dirección como una cadena.
     */
    @Override
    public String toString() {
        return "Direccion{" + "IDDireccion=" + IDDireccion + ", calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + ", codigoPostal=" + codigoPostal + '}';
    }
}
