package com.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServerSocket {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(9090)){
            while (true){
                System.out.println(" Сервер ждет подключения клиента...");
                Socket socket = serverSocket.accept();
                System.out.println("Клиент подключился, создаем socket...");
                Thread thread = new Thread(new ClientSocket(socket));
                thread.start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
