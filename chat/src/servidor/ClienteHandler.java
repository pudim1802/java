package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Set;

public class ClienteHandler extends Thread{

    private Socket cliente;

    private PrintWriter escritor;

    private Set<PrintWriter> listaescritores;


    public ClienteHandler(Socket cliente, Set<PrintWriter> listaescritores) {
        this.listaescritores = listaescritores;
        this.cliente = cliente;
    }


        @Override
        public void run() {
            try{
                BufferedReader leitor = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                PrintWriter escritor = new PrintWriter(cliente.getOutputStream(), true);

                synchronized (listaescritores) {
                    listaescritores.add(escritor);
                }

                String usuario = leitor.readLine();
                transmitir("Usuário " + usuario + " entrou no chat!");
                System.out.println("Usuário " + usuario + " conectado!");

                String mesagem;

                while ((mesagem = leitor.readLine()) != null) {
                    if(mesagem.equals("sair")){
                        break;
                    }

                    transmitir(usuario + ": " + mesagem);
                }

                synchronized (listaescritores) {
                    listaescritores.remove(escritor);
                }
                transmitir("Usuário " + usuario + " saiu do chat!");



            }catch (IOException exception){
                exception.printStackTrace();
            }

        }

        public void transmitir(String mensagem){
            for (PrintWriter escritor : listaescritores) {
                escritor.println(mensagem);
            }

        }

}
