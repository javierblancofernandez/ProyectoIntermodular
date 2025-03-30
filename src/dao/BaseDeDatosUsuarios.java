/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pojos.Usuario;
import pojos.UsuarioPassword;

/**
 *
 * @author javib
 */
public class BaseDeDatosUsuarios {
        /*String url = "jdbc:mysql://localhost:3306/inventario?useUnicode="
            + "true&useJDBCCompliantTimezoneShift="
            + "true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";*/
    String url = "jdbc:mysql://localhost:3306/userprueba";
    //String password = "admin";
    String password = "Administr@d0r";
    //String usuario = "root";
    String username = "interPrueba";
    Connection con = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    public BaseDeDatosUsuarios() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BaseDeDatosUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void insertarUsuarioPagina(Usuario usuario,Integer Id) {

        try {
            
            
            con = DriverManager.getConnection(url, username, password);
            //File fileFoto = producto.getFotoProducto();
            //FileInputStream fis = new FileInputStream(fileFoto);
            
            String sql = "INSERT INTO registroprueba(NombrePagina,urlPagina,nombreUserPagina,password,id_usuarioPassword)"
                    + " VALUES (?,?,?,?,?)";

            pstm = con.prepareStatement(sql);
            pstm.setString(1, usuario.getNombre());
            pstm.setString(2, usuario.getUrl());
            pstm.setString(3, usuario.getNombreUser());
            pstm.setString(4, usuario.getPassword());
            pstm.setInt(5, Id);
            int numero = pstm.executeUpdate();
            
            System.out.println("numero"+numero);
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
    
    public ArrayList<Usuario> obtenerUsuariosPagina(Integer sesionId) {
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        try {
            System.out.println("Id del usuario"+sesionId);
            con = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM registroprueba WHERE id_usuarioPassword ="+sesionId+" ORDER BY NombrePagina";
            
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String pagina = rs.getString("NombrePagina");
                String url = rs.getString("urlPagina");
                String useremail = rs.getString("nombreUserPagina");
                String password = rs.getString("password");
                
                Usuario user = new Usuario(id, pagina, url, useremail, password);
                listaUsuarios.add(user);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatosUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("listaUsuarios"+listaUsuarios);
        return listaUsuarios;
    }
    
    public boolean updateUsuario(Usuario user,Integer userSessionId){
        boolean resultado;
        try {
            con = DriverManager.getConnection(url, username, password);

            String sql = "UPDATE registroprueba SET NombrePagina=? , urlPagina=?, nombreUserPagina=?, password=? , id_usuarioPassword=? WHERE id=?";

            pstm = con.prepareStatement(sql);

            pstm.setString(1, user.getNombre());
            pstm.setString(2, user.getUrl());
            pstm.setString(3, user.getNombreUser());
            pstm.setString(4, user.getPassword());
            pstm.setInt(5, userSessionId);
            pstm.setInt(6, user.getIdUser());
            pstm.executeUpdate();
            
            resultado=true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            resultado=false;
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                resultado=false;
            }
        }
    
    
    
        return resultado;
    }
    
        public boolean borrarUsuarioPagina(Usuario user){
        boolean resultado;
        try {
            con = DriverManager.getConnection(url, username, password);

            String sql = "DELETE FROM registroprueba WHERE id=?";

            pstm = con.prepareStatement(sql);

            pstm.setInt(1, user.getIdUser());
            pstm.executeUpdate();
            
            resultado=true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            resultado=false;
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                resultado=false;
            }
        }

        return resultado;
    }
    
    public ArrayList<Usuario> obtenerUsuarioPorCriterio(String criterio,Integer sesionId){
        
        ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
        try {

            con = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM registroprueba"
                    + " WHERE NombrePagina LIKE '" + criterio + "%'"
                    + "AND id_usuarioPassword ="+ sesionId+"";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nombrePagina = rs.getString("NombrePagina");
                String urlPagina = rs.getString("urlPagina");
                String userPagina = rs.getString("nombreUserPagina");
                String passordPagina = rs.getString("password");
                
                Usuario usuario = new Usuario(id, nombrePagina, urlPagina,userPagina, passordPagina);
                listaUsuario.add(usuario);

            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatosUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaUsuario;
    
    }
    /* Login USUARIOS*/
    public boolean login(String usuario,String contrasena){
        
        ArrayList<UsuarioPassword> userPass = new ArrayList<UsuarioPassword>();
        boolean resultado=false;
         
        try {

            con = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM usuariopassword"
                    + " WHERE usuario =  '" + usuario + "'"
                    + "AND contrasena = '" + contrasena + "'";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String usuarionombre = rs.getString("usuario");
                String usuarioemail = rs.getString("email");
                String usuarioPassword = rs.getString("contrasena");

                
                UsuarioPassword usuariopass = new UsuarioPassword( usuarionombre, usuarioemail,usuarioPassword);
                userPass.add(usuariopass);
            

            }
            System.out.println("estoy en login vacio"+ userPass.isEmpty());
            resultado = !userPass.isEmpty();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatosUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return resultado;
    }
    
    /* REGISTRO USUARIOS PARA CONTRASEÑA */
    public boolean insertUsuarioPassword(UsuarioPassword userPass){
        boolean resultado=false;
        
        try {
            con = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO usuariopassword(usuario,email,contrasena)"
                    + " VALUES (?,?,?)";

            pstm = con.prepareStatement(sql);
            pstm.setString(1, userPass.getUsuarioNombre());
            pstm.setString(2, userPass.getUsuarioEmail());
            pstm.setString(3, userPass.getUsuarioPassword());
            
            int numero = pstm.executeUpdate();
            
            System.out.println("numero"+numero);
            resultado =true;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            resultado =false;
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                resultado =false;
            }
        }
        
        return resultado;
    }
    
        public Integer obtenerUsuarioLoginPorCriterio(String criterio){
        
        ArrayList<UsuarioPassword> listaUsuario = new ArrayList<UsuarioPassword>();
        try {

            con = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM usuariopassword"
                    + " WHERE usuario LIKE '" + criterio + "%'"
                    + "ORDER BY usuario";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nombre = rs.getString("usuario");
                String email = rs.getString("email");
                String contrasena = rs.getString("contrasena");
                
                UsuarioPassword usuario = new UsuarioPassword(id, nombre, email,contrasena);
                listaUsuario.add(usuario);

            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatosUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaUsuario.get(0).getUsuarioId();
    
    }
}
