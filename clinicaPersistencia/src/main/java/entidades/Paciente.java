/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDate;

/**
 *
 * @author Alici
 */
public class Paciente extends Usuario {

    private String nombresPaciente;
    private String apellidoPaternoPaciente;
    private String apellidoMaternoPaciente;
    private String correo;
    private String telefono;
    private int edad;
    private LocalDate fechaNacimiento;
    private Direccion direccion;

    /**
     * Constructor vacío, hereda el constructor vacío de Usuario.
     */
    public Paciente() {
        super();
    }

    /**
     * Constructor con todos los atributos, incluyendo los de la clase Usuario.
     * 
     * @param IDUsuario Identificador del usuario
     * @param contrasenaUsuario Contraseña del usuario
     * @param nombresPaciente Nombres del paciente
     * @param apellidoPaternoPaciente Apellido paterno del paciente
     * @param apellidoMaternoPaciente Apellido materno del paciente
     * @param correo Correo del paciente
     * @param telefono Teléfono del paciente
     * @param edad Edad del paciente
     * @param fechaNacimiento Fecha de nacimiento del paciente
     * @param direccion Dirección del paciente
     */
    public Paciente(int IDUsuario, String contrasenaUsuario, String nombresPaciente, String apellidoPaternoPaciente, 
                    String apellidoMaternoPaciente, String correo, String telefono, int edad, 
                    LocalDate fechaNacimiento, Direccion direccion) {
        super(IDUsuario, correo, contrasenaUsuario);
        this.nombresPaciente = nombresPaciente;
        this.apellidoPaternoPaciente = apellidoPaternoPaciente;
        this.apellidoMaternoPaciente = apellidoMaternoPaciente;
        this.correo = correo;
        this.telefono = telefono;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    /**
     * Constructor con solo los datos del paciente, sin información de usuario.
     * 
     * @param nombresPaciente Nombres del paciente
     * @param apellidoPaternoPaciente Apellido paterno del paciente
     * @param apellidoMaternoPaciente Apellido materno del paciente
     * @param correo Correo del paciente
     * @param telefono Teléfono del paciente
     * @param fechaNacimiento Fecha de nacimiento del paciente
     * @param direccion Dirección del paciente
     */
    public Paciente(String nombresPaciente, String apellidoPaternoPaciente, String apellidoMaternoPaciente, 
                    String correo, String telefono, LocalDate fechaNacimiento, Direccion direccion) {
        this.nombresPaciente = nombresPaciente;
        this.apellidoPaternoPaciente = apellidoPaternoPaciente;
        this.apellidoMaternoPaciente = apellidoMaternoPaciente;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    /**
     * Constructor con todos los atributos de la clase Usuario y los del paciente.
     * 
     * @param IDUsuario Identificador del usuario
     * @param contrasenaUsuario Contraseña del usuario
     * @param nombresPaciente Nombres del paciente
     * @param apellidoPaternoPaciente Apellido paterno del paciente
     * @param apellidoMaternoPaciente Apellido materno del paciente
     * @param correo Correo del paciente
     * @param telefono Teléfono del paciente
     * @param fechaNacimiento Fecha de nacimiento del paciente
     * @param direccion Dirección del paciente
     */
    public Paciente(int IDUsuario, String contrasenaUsuario, String nombresPaciente, String apellidoPaternoPaciente, 
                    String apellidoMaternoPaciente, String correo, String telefono, LocalDate fechaNacimiento, 
                    Direccion direccion) {
        super(IDUsuario, correo, contrasenaUsuario);
        this.nombresPaciente = nombresPaciente;
        this.apellidoPaternoPaciente = apellidoPaternoPaciente;
        this.apellidoMaternoPaciente = apellidoMaternoPaciente;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    /**
     * Constructor con los atributos del paciente pero sin IDUsuario.
     * 
     * @param contrasenaUsuario Contraseña del usuario
     * @param nombresPaciente Nombres del paciente
     * @param apellidoPaternoPaciente Apellido paterno del paciente
     * @param apellidoMaternoPaciente Apellido materno del paciente
     * @param correo Correo del paciente
     * @param telefono Teléfono del paciente
     * @param fechaNacimiento Fecha de nacimiento del paciente
     * @param direccion Dirección del paciente
     */
    public Paciente(String contrasenaUsuario, String nombresPaciente, String apellidoPaternoPaciente, 
                    String apellidoMaternoPaciente, String correo, String telefono, 
                    LocalDate fechaNacimiento, Direccion direccion) {
        super(correo, contrasenaUsuario);
        this.nombresPaciente = nombresPaciente;
        this.apellidoPaternoPaciente = apellidoPaternoPaciente;
        this.apellidoMaternoPaciente = apellidoMaternoPaciente;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    /**
    * Obtiene la edad del paciente.
    * 
    * @return la edad del paciente.
    */
   public int getEdad() {
       return edad;
   }

   /**
    * Establece la edad del paciente.
    * 
    * @param edad la edad del paciente.
    */
   public void setEdad(int edad) {
       this.edad = edad;
   }

   /**
    * Obtiene el nombre del paciente.
    * 
    * @return el nombre del paciente.
    */
   public String getNombresPaciente() {
       return nombresPaciente;
   }

   /**
    * Establece el nombre del paciente.
    * 
    * @param nombresPaciente el nombre del paciente.
    */
   public void setNombresPaciente(String nombresPaciente) {
       this.nombresPaciente = nombresPaciente;
   }

   /**
    * Obtiene el apellido paterno del paciente.
    * 
    * @return el apellido paterno del paciente.
    */
   public String getApellidoPaternoPaciente() {
       return apellidoPaternoPaciente;
   }

   /**
    * Establece el apellido paterno del paciente.
    * 
    * @param apellidoPaternoPaciente el apellido paterno del paciente.
    */
   public void setApellidoPaternoPaciente(String apellidoPaternoPaciente) {
       this.apellidoPaternoPaciente = apellidoPaternoPaciente;
   }

   /**
    * Obtiene el apellido materno del paciente.
    * 
    * @return el apellido materno del paciente.
    */
   public String getApellidoMaternoPaciente() {
       return apellidoMaternoPaciente;
   }

   /**
    * Establece el apellido materno del paciente.
    * 
    * @param apellidoMaternoPaciente el apellido materno del paciente.
    */
   public void setApellidoMaternoPaciente(String apellidoMaternoPaciente) {
       this.apellidoMaternoPaciente = apellidoMaternoPaciente;
   }

   /**
    * Obtiene el correo electrónico del paciente.
    * 
    * @return el correo electrónico del paciente.
    */
   public String getCorreo() {
       return correo;
   }

   /**
    * Establece el correo electrónico del paciente.
    * 
    * @param correo el correo electrónico del paciente.
    */
   public void setCorreo(String correo) {
       this.correo = correo;
   }

   /**
    * Obtiene el teléfono del paciente.
    * 
    * @return el teléfono del paciente.
    */
   public String getTelefono() {
       return telefono;
   }

   /**
    * Establece el teléfono del paciente.
    * 
    * @param telefono el teléfono del paciente.
    */
   public void setTelefono(String telefono) {
       this.telefono = telefono;
   }

   /**
    * Obtiene la fecha de nacimiento del paciente.
    * 
    * @return la fecha de nacimiento del paciente.
    */
   public LocalDate getFechaNacimiento() {
       return fechaNacimiento;
   }

   /**
    * Establece la fecha de nacimiento del paciente.
    * 
    * @param fechaNacimiento la fecha de nacimiento del paciente.
    */
   public void setFechaNacimiento(LocalDate fechaNacimiento) {
       this.fechaNacimiento = fechaNacimiento;
   }

   /**
    * Obtiene la dirección del paciente.
    * 
    * @return la dirección del paciente.
    */
   public Direccion getDireccion() {
       return direccion;
   }

   /**
    * Establece la dirección del paciente.
    * 
    * @param direccion la dirección del paciente.
    */
   public void setDireccion(Direccion direccion) {
       this.direccion = direccion;
   }
    /**
     * Devuelve una representación en cadena del paciente.
     * 
     * @return La información del paciente en formato de cadena.
     */
    @Override
    public String toString() {
        return "Paciente{" + "nombresPaciente=" + nombresPaciente + ", apellidoPaternoPaciente=" + apellidoPaternoPaciente + ", apellidoMaternoPaciente=" + apellidoMaternoPaciente + ", correo=" + correo + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + '}';
    }
}
