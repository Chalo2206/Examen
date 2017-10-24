package me.Gonzalo.Libreria.dao.interfaces;

import java.util.List;
import me.Gonzalo.Libreria.dao.clases.Libro;

public interface LibroDao {
    public List<Libro> listar();
    public void guardar(Libro libro);
    public void modificar(Libro libro);
    public void borrar(Libro libro);    
}
