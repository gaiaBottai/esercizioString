package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("server partito...");
        ServerSocket s=new ServerSocket(3000); //creo la server socket
        
        do{
            Socket ss= s.accept();//questa socket serve per comunicare con il thread quindi la passo
            MioThread t= new MioThread(ss);
            t.start();
        }while(true);
    }
}