/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

/**
 *
 * @author javib
 * pojo para el registro en la app
 * 
 */
public class UsuarioPassword {
    Integer usuarioId;
    String usuarioNombre;
    String usuarioEmail;
    String usuarioPassword;

    public UsuarioPassword() {
    }

    public UsuarioPassword(String usuarioNombre, String usuarioEmail, String usuarioPassword) {
        this.usuarioNombre = usuarioNombre;
        this.usuarioEmail = usuarioEmail;
        this.usuarioPassword = usuarioPassword;
    }
    
    public UsuarioPassword(Integer usuarioId,String usuarioNombre, String usuarioEmail, String usuarioPassword) {
    this.usuarioId = usuarioId;
    this.usuarioNombre = usuarioNombre;
    this.usuarioEmail = usuarioEmail;
    this.usuarioPassword = usuarioPassword;
    }

    public UsuarioPassword(Integer id, String pagina, String url, UsuarioPassword user, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }
        
    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getUsuarioPassword() {
        return usuarioPassword;
    }

    public void setUsuarioPassword(String usuarioPassword) {
        this.usuarioPassword = usuarioPassword;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    
          
}
