package me.Gonzalo.Libreria.dao.clases;

public class Autor {
    private int idAutor;
    private String nombres;
    private String apellidos;


    public Autor() {
        this.idAutor=0;
        this.nombres="";
        this.apellidos="";

      }   

    public Autor(int idAutor) {
        this.idAutor = idAutor;
    }

    public Autor(int idAutor, String nombres, String apellidos) {
        this.idAutor = idAutor;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }   

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
