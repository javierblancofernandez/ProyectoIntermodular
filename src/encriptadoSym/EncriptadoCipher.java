/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encriptadoSym;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author javib
 */
public class EncriptadoCipher {
    
    public EncriptadoCipher(){
    }
    
    public static byte[] transformar(byte[] input, String pass, boolean encript) {

    byte out[] = {};

    try {

        Cipher cipher = Cipher.getInstance("AES");

        SecretKey clave = new SecretKeySpec(pass.getBytes(), "AES");

        if (encript) {
            cipher.init(Cipher.ENCRYPT_MODE, clave);
        } else {
            cipher.init(Cipher.DECRYPT_MODE, clave);
        }

        out = cipher.doFinal(input);

    } catch (NoSuchAlgorithmException ex) {
        System.out.println(ex.getMessage());
    } catch (NoSuchPaddingException ex) {
        System.out.println(ex.getMessage());
    } catch (InvalidKeyException ex) {
        System.out.println(ex.getMessage());
    } catch (IllegalBlockSizeException ex) {
        System.out.println(ex.getMessage());
    } catch (BadPaddingException ex) {
        System.out.println(ex.getMessage());
    }
    return out;
}


/**
 * Devuelve un texto encriptado en Base64
 * @param input Texto a encriptar
 * @param pass Password
 * @return Texto encriptado en Base64
 */
public static String encriptar(String input, String pass){
    String res="";
    try {
        Cipher cipher = Cipher.getInstance("AES");

        SecretKey clave = new SecretKeySpec(pass.getBytes(), "AES");


        cipher.init(Cipher.ENCRYPT_MODE, clave);


        byte [] out = cipher.doFinal(input.getBytes());

        res=Base64.getEncoder().encodeToString(out);

    } catch (InvalidKeyException ex) {
        System.out.println(ex.getMessage());
    } catch (NoSuchAlgorithmException ex) {
        System.out.println(ex.getMessage());
    } catch (NoSuchPaddingException ex) {
        System.out.println(ex.getMessage());
    } catch (IllegalBlockSizeException ex) {
        System.out.println(ex.getMessage());
    } catch (BadPaddingException ex) {
        System.out.println(ex.getMessage());
    }

    return res;
}

/**
 * Desencripta un texto en Base64
 * @param input texto en Base64
 * @param pass Password
 * @return El texto en claro
 */
public static String desencriptar(String input, String pass){
    String res="";
    try {
        Cipher cipher = Cipher.getInstance("AES");

        SecretKey clave = new SecretKeySpec(pass.getBytes(), "AES");


        cipher.init(Cipher.DECRYPT_MODE, clave);


        byte [] out = cipher.doFinal(Base64.getDecoder().decode(input));

        res=new String(out);

    } catch (InvalidKeyException ex) {
        System.out.println(ex.getMessage());
    } catch (NoSuchAlgorithmException ex) {
        System.out.println(ex.getMessage());
    } catch (NoSuchPaddingException ex) {
        System.out.println(ex.getMessage());
    } catch (IllegalBlockSizeException ex) {
        System.out.println(ex.getMessage());
    } catch (BadPaddingException ex) {
        System.out.println(ex.getMessage());
    }

    return res;
}
}
