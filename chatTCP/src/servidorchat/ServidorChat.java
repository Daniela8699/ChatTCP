package servidorchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class ServidorChat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Carga el archivo de configuracion de log4J
       
        
        int puerto = 1234;
        int maximoConexiones = 5; // Maximo de conexiones simultaneas
        ServerSocket servidor = null; 
        Socket socket = null;
        MensajesChat mensajes = new MensajesChat();
        
        try {
            // Se crea el serverSocket
            servidor = new ServerSocket(puerto, maximoConexiones);
            
            // Bucle infinito para esperar conexiones
            while (true) {
              
                socket = servidor.accept();
                
                
                ConexionCliente cc = new ConexionCliente(socket, mensajes);
                cc.start();
                
            }
        } catch (IOException ex) {
           
        } finally{
            try {
                socket.close();
                servidor.close();
            } catch (IOException ex) {
               
            }
        }
    }
}
