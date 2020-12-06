import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    public static String clientsName;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);;
        String input, message,ip;
        int puerto;

        System.out.println("Ingrese Nombre del cliente");
        clientsName = scanner.nextLine();
        System.out.println("Ingrese Ip del servidor");
        ip = scanner.nextLine();
        System.out.println("Ingrese el Puerto del servidor");
        puerto = Integer.parseInt(scanner.nextLine());

        Connection servidor = new Connection(0,ip,puerto);
        servidor.conectar();
        int i = 1;
        while(i == 1){
            System.out.println("Ingrese Comando:");
            input = scanner.nextLine();
            if (input.equals("disconnect")) {
                message = "QUIT";
                i++;
            } else {
                message = clientsName + " :" + input;
                servidor.consultar(message);
            }

            }
        servidor.desconectar();
        }


    }


