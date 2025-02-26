/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author benjy
 */
public class DireccionDTO {

    private int idDireccion;
    private String calle;
    private String numero;
    private String colonia;
    private String codigoPostal;

    /**
     * Constructor con todos los parámetros.
     * 
     * @param idDireccion El ID único de la dirección.
     * @param calle La calle de la dirección.
     * @param numero El número de la dirección (exterior o interior).
     * @param colonia La colonia o vecindad de la dirección.
     * @param codigoPostal El código postal de la dirección.
     */
    public DireccionDTO(int idDireccion, String calle, String numero, String colonia, String codigoPostal) {
        this.idDireccion = idDireccion;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Constructor vacío para la clase DireccionDTO.
     */
    public DireccionDTO() {
    }

    /**
     * Obtiene el ID de la dirección.
     * 
     * @return El ID de la dirección.
     */
    public int getIdDireccion() {
        return idDireccion;
    }

    /**
     * Establece el ID de la dirección.
     * 
     * @param idDireccion El nuevo ID de la dirección.
     */
    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
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
     * @param calle La nueva calle de la dirección.
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
     * @param colonia La nueva colonia de la dirección.
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
     * @param codigoPostal El nuevo código postal de la dirección.
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
