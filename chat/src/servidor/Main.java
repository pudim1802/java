package servidor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Main {
    private static Set<PrintWriter> escritores = new HashSet<>();

    private static final int PORTA = 8080;

         static void main(String[] args) {


             try(ServerSocket servidor = new ServerSocket(PORTA)) {
                 System.out.println("servidor rodando porta 8080");
                 while (true){
                    new ClienteHandler(
                            servidor.accept(),
                            escritores
                    ).start();



                 }





             }catch (IOException exception) {
                 exception.printStackTrace();
             }


    }
}