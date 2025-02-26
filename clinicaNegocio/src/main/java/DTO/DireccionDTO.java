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
     * Constructor de la clase DireccionDTO.
     * 
     * @param idDireccion Identificador único de la dirección.
     * @param calle Calle donde se encuentra la dirección.
     * @param numero Número de la casa o edificio en la dirección.
     * @param colonia Colonia o barrio donde se encuentra la dirección.
     * @param codigoPostal Código postal correspondiente a la dirección.
     */
    public DireccionDTO(int idDireccion, String calle, String numero, String colonia, String codigoPostal) {
        this.idDireccion = idDireccion;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Constructor vacío de la clase DireccionDTO.
     */
    public DireccionDTO() {
    }

    /**
     * Obtiene el identificador de la dirección.
     * 
     * @return El identificador de la dirección.
     */
    public int getIdDireccion() {
        return idDireccion;
    }

    /**
     * Establece el identificador de la dirección.
     * 
     * @param idDireccion El identificador de la dirección.
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
     * @param calle La calle de la dirección.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene el número de la casa o edificio de la dirección.
     * 
     * @return El número de la casa o edificio de la dirección.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número de la casa o edificio de la dirección.
     * 
     * @param numero El número de la casa o edificio.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene la colonia o barrio de la dirección.
     * 
     * @return La colonia o barrio de la dirección.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia o barrio de la dirección.
     * 
     * @param colonia La colonia o barrio de la dirección.
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
     * @param codigoPostal El código postal de la dirección.
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}