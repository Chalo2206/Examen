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
import me.Gonzalo.Libreria.dao.clases.Autor;
import me.Gonzalo.Libreria.dao.interfaces.AutorDao;
import me.Gonzalo.Libreria.jdbc.ConexionSingleton;

public class AutorImpl implements AutorDao {

    @Override
    public List<Autor> listar() {
        try{
            Connection conn = ConexionSingleton.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Autor");
            List<Autor> Autor = new ArrayList<>();
            while(rs.next()){
                Autor autor = new Autor();                
                autor.setIdAutor(rs.getInt("idAutor"));
                autor.setNombres(rs.getString("nombres"));
                autor.setApellidos(rs.getString("apellidos"));
                Autor.add(autor);
            }
            return Autor;
        }catch(SQLException ex){
            Logger.getLogger(AutorImpl.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        }
    }

    @Override
    public void guardar(Autor autor) {
        try{
            Connection conn = ConexionSingleton.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Autor VALUES (?,?,?)");
            ps.setInt(1, autor.getIdAutor());
            ps.setString(2, autor.getNombres());
            ps.setString(3, autor.getApellidos());           
            ps.executeUpdate();           
        }catch(SQLException ex){
            Logger.getLogger(AutorImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @Override
    public void modificar(Autor autor) {
        try{
           Connection conn = ConexionSingleton.getConnection();
           PreparedStatement ps = conn.prepareStatement("UPDATE Autor SET nombres=?, apellidos=? WHERE idAutor=?");           
           ps.setString(1, autor.getNombres());
           ps.setString(2, autor.getApellidos());
           ps.setInt(3, autor.getIdAutor());
           ps.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(AutorImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @Override
    public void borrar(Autor autor) {
        try{
            Connection conn = ConexionSingleton.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Autor WHERE idAutor = ?");
            ps.setInt(1, autor.getIdAutor());
            ps.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(AutorImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
}
