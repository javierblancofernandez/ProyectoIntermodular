# Proyecto Intermodular - Gestor Seguro de Contraseñas 🔒  

Aplicación de escritorio desarrollada en **Java** con interfaz gráfica **Swing**, diseñada para gestionar y almacenar credenciales de acceso (usuarios y contraseñas) de forma segura, integrando encriptación y notificaciones por correo electrónico.  

## Características principales 🚀  
- **Encriptación robusta**: Uso de la librería **Javax.crypto.Cipher** para proteger contraseñas almacenadas.  
- **Notificaciones automáticas**: Envío de correos electrónicos mediante **hilos** (multithreading) al registrar nuevas credenciales.  
- **Interfaz intuitiva**: Diseñada con **Swing** para una experiencia de usuario fluida.  
- **Persistencia de datos**: Almacenamiento en una base de datos **MySQL** gestionada con **XAMPP**.  

## Tecnologías utilizadas ⚙️  
- **Lenguaje**: Java (JDK).  
- **Interfaz gráfica**: Swing.  
- **Comunicación externa**: Envío de correos con **JavaMail API** y multithreading. 
- **Base de datos**: MySQL + XAMPP (servidor local).  
- **Control de versiones**: Git + GitHub.  

## Requisitos previos 📋  
1. **Java** (versión 8 o superior).  
2. **XAMPP** (para MySQL y servidor local).  
3. **Dependencias**:  
   - `javax.mail` (para correos electrónicos).  
   - `javax.crypto` (para encriptación).  
4. Clonar el repositorio:  
   ```bash  
   git clone https://github.com/javierblancofernandez/ProyectoIntermodular.git  
