package com.socket;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientSocket implements Runnable{
    private Socket socket;

    public ClientSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        SimpleDateFormat formatter = new SimpleDateFormat("YYDDMMHHmmSS");
     //   String filename = ".\\src\\serverfiles\\clientfile.txt";
        String filename = ".\\src\\serverfiles\\clientfile" + formatter.format(new Date())+".txt";
        System.out.println(filename);
try (BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
     BufferedWriter out = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
     BufferedWriter outFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)))
    ){
    System.out.println("Ждем передачи данных от клиента...");
    String line = in.readLine();
    System.out.println("приняли от клиента строку " + line);
    outFile.write(line+'\n');
    while (in.ready()){
        line = in.readLine();
        System.out.println("приняли от клиеента строку " + line);
        outFile.write(line+'\n');
    }
    out.write("Данные приняты\n'");
    out.flush();
    System.out.println("Принятые данные записаны в файл "+ filename);

}catch (IOException exception){
    exception.printStackTrace();
}

    }
}
