package Cliente2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente2 {

    static void main(String[] args) {
        System.out.println("digite seu nome: ");
        Scanner ler = new Scanner(System.in);
        String usuario = ler.nextLine();

        try{
            Socket cliente = new Socket("localhost", 8080);
            System.out.println("Conectado ao servidor!");

            PrintWriter escritor = new PrintWriter(cliente.getOutputStream(), true);
            BufferedReader leitor = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

            escritor.println(usuario);

            Thread receptor = new Thread(() -> {
                try {
                    String mensagemRecebida;
                    while ((mensagemRecebida = leitor.readLine()) != null) {
                        System.out.println(mensagemRecebida);
                    }
                }catch (IOException exception) {
                    exception.printStackTrace();
                }
            });

            receptor.start();

            while (true){
                Thread.sleep(300);

                String mensagemServidor = ler.nextLine();
                if(mensagemServidor.equals("sair"))break;

                escritor.println(mensagemServidor);


            }
            System.out.println("desconectado do servidor!");
            receptor.interrupt();





        }catch (IOException exception) {
            exception.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
