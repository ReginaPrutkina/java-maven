package com.socket;

import java.io.*;
import java.net.Socket;

public class MainClientSocket {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 9090);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader inFile = new BufferedReader(new InputStreamReader(new FileInputStream(".\\src\\clientfiles\\clientfile.txt")))
            ){
            String line;
            while (inFile.ready()) {
                line = inFile.readLine();
                System.out.println(line);
                out.write(line+'\n');
                out.flush();
            }
            System.out.println(" Ответ от сервера " + in.readLine()); /// получили какой-то ответ от сервера
            // закрываем соединение автоматически try-resource

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
