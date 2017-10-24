package me.Gonzalo.Libreria.dao.clases;

public class Libro {
    private int idLibro;
    private String nombre;
    private String categoria;
    private String isbn;
    private Autor autor;

    public Libro() {
        this.idLibro =0;
        this.nombre="";
        this.categoria="";
        this.isbn="";
        this.autor = new Autor();
    }

    public Libro(int idLibro, String nombre, String categoria, String isbn, Autor autor) {
        this.idLibro = idLibro;
        this.nombre = nombre;
        this.categoria = categoria;
        this.isbn = isbn;
        this.autor = autor;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }    
}
