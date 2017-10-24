package me.Gonzalo.Libreria.dao.interfaces;

import java.util.List;
import me.Gonzalo.Libreria.dao.clases.Autor;

public interface AutorDao {
    public List<Autor>listar();
    public void guardar(Autor autor);
    public void modificar(Autor autor);
    public void borrar(Autor autor);
}
