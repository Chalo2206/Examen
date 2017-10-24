package me.Gonzalo.Libreria.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.Gonzalo.Libreria.dao.clases.Libro;
import me.Gonzalo.Libreria.dao.interfaces.LibroDao;
import me.Gonzalo.Libreria.jdbc.ConexionSingleton;

public class LibroImpl implements LibroDao {

    @Override
    public List<Libro> listar() {
        try{
            Connection conn = ConexionSingleton.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Libro");
            List<Libro> libros = new ArrayList<>();
            while(rs.next()){
                Libro libro = new Libro();                
                libro.setIdLibro(rs.getInt("idLibro"));
                libro.setNombre(rs.getString("nombres"));
                libro.setCategoria(rs.getString("categoria"));
                libro.setIsbn(rs.getString("isbn"));
                libros.add(libro);
            }
            return libros;
        }catch(SQLException ex){
            Logger.getLogger(LibroImpl.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        }
    }

    @Override
    public void guardar(Libro libro) {
        try{
            Connection conn = ConexionSingleton.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Libro VALUES (?,?,?,?,?)");
            ps.setInt(1, libro.getIdLibro());
            ps.setString(2, libro.getNombre());
            ps.setString(3, libro.getCategoria());
            ps.setString(4, libro.getIsbn());
            ps.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(LibroImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @Override
    public void modificar(Libro libro) {
        try{
           Connection conn = ConexionSingleton.getConnection();
           PreparedStatement ps = conn.prepareStatement("UPDATE Libro SET nombre=?, categoria=?, isbn=?, libroCol=? WHERE idLibro=?");
           ps.setInt(1, libro.getIdLibro());
           ps.setString(2, libro.getNombre());
           ps.setString(3, libro.getCategoria());
           ps.setString(4, libro.getIsbn());
           ps.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(LibroImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @Override
    public void borrar(Libro libro) {
        try{
            Connection conn = ConexionSingleton.getConnection();
           PreparedStatement ps = conn.prepareStatement("DELETE FROM Libro WHERE idLibro = ?");
            ps.setInt(1, libro.getIdLibro());
            ps.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(LibroImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
}
