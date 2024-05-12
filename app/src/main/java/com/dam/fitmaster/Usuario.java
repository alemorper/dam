package com.dam.fitmaster;

public class Usuario {
    private String usuario;
    private String contraseña;
    private String nombre;
    private String apellidos;
    private String correo;
    private int edad;
    private String genero;
    private String nivelActual;
    private String objetivo;
    private String nivelExperiencia;
    private String frecuenciaEntreno;
    //private String parteCuerpoFav;

    // Constructor
    public Usuario(String usuario, String contraseña, String nombre, String apellidos, String correo, int edad,
                   String genero, String nivelActual, String objetivo,
                   String frecuenciaEntreno) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.edad = edad;
        this.genero = genero;

        this.nivelActual = nivelActual;
        this.objetivo = objetivo;

        this.frecuenciaEntreno = frecuenciaEntreno;
        //this.parteCuerpoFav = parteCuerpoFav;
    }

    public Usuario (){

    }

    // Getters y setters para los atributos
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNivelActual() {
        return nivelActual;
    }

    public void setNivelActual(String nivelActual) {
        this.nivelActual = nivelActual;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }


    public String getFrecuenciaEntreno() {
        return frecuenciaEntreno;
    }

    public void setFrecuenciaEntreno(String frecuenciaEntreno) {
        this.frecuenciaEntreno = frecuenciaEntreno;
    }

}
