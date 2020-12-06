import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection{
    protected Socket sk;
    protected DataOutputStream dos;
    protected DataInputStream dis;
    private int id;
    private String ip;
    private int port;

    public Connection(int id,String ip,int port) {
        this.id = id;

        this.ip = ip;
        this.port = port;
    }
    public void desconectar() {
        try {
            System.out.println("Desconectado del Servidor");
            dis.close();
            dos.close();
            sk.close();
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultar(String message){
        try {
            dos.writeUTF(message);
            String respuesta = "";
            respuesta = dis.readUTF();
            System.out.println("Servidor devuelve respuesta: " + respuesta);
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void conectar(){
        try {
            sk = new Socket(ip, port);
            dos = new DataOutputStream(sk.getOutputStream());
            dis = new DataInputStream(sk.getInputStream());
            System.out.println(dis.readUTF());

        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
