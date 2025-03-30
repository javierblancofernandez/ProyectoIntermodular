/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emailService;

import pojos.Usuario;
import pojos.UsuarioPassword;

/**
 *
 * @author javib
 */
public class EmailSender implements Runnable{
    
    //private Usuario user;
    private String userEmail;
    private String asunto;
    private String mensaje;
    
    /*public EmailSender(Usuario user) {
        this.user = user;
    }*/
    
     public EmailSender(String userEmail, String asunto, String mensaje) {
        this.userEmail = userEmail;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        System.out.println(userEmail);
        try {
            if(!(userEmail==null)){
                enviarEmailRegistro(userEmail,asunto,mensaje);
                System.out.println("Correo enviado a: " + userEmail+"en run()");
            }else if(userEmail.equalsIgnoreCase("admin@example.com")){
                enviarEmailRegistro(userEmail,asunto,mensaje);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al enviar el correo: " + e.getMessage());
        }
    }

  
    private void enviarEmailRegistro(String userEmail, String asunto, String mensaje) throws Exception {
        // Simular el envío de correo (reemplazar con lógica real si es necesario)
        System.out.println("Enviando correo a " + userEmail + "...");
        Thread.sleep(2000); // Simular retraso
        System.out.println("Correo enviado a " + userEmail + " con asunto: " + asunto);
    }
    private void enviarEmailRegistroadmin(String userEmail, String asunto, String mensaje) throws Exception {
        // Simular el envío de correo (reemplazar con lógica real si es necesario)
        System.out.println("Enviando correo a " + userEmail + "...");
        Thread.sleep(2000); // Simular retraso
        System.out.println("Correo enviado a " + userEmail + " con asunto: " + asunto);
    }
}
    

