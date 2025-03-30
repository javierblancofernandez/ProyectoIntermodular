/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

/**
 *
 * @author javib
 * pojo para hacer guardar las páginas
 * 
 */
public class Usuario {
    
    private Integer idUser;
    private String nombre;
    private String url;
    private String nombreUser;
    private String password;

    public Usuario() {
    }

    public Usuario(Integer idUser, String nombre, String url, String nombreUser, String password) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.url = url;
        this.nombreUser = nombreUser;
        this.password = password;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
