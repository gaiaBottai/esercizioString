package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("client partito");
        Scanner scanner=new Scanner(System.in);
        Socket ss=new Socket("localhost",3000);
        BufferedReader in = new BufferedReader(new InputStreamReader(ss.getInputStream()));
        DataOutputStream out = new DataOutputStream(ss.getOutputStream());
        String operazione;
        String parola;
        String parolafinale;
        do{

            System.out.println("scegli operazione");
            System.out.println("1.Maiuscolo");
            System.out.println("2.minuscolo");
            System.out.println("3.inverso");
            System.out.println("4.conta");
            System.out.println("5.esci");
        
            operazione=scanner.nextLine();
         if(operazione.equals("5")){
            out.writeBytes(operazione+"\n");//invia al thread l'operazione di chiusura in questo caso
            ss.close();
            
         }
         else{
            System.out.println("inserisci la parola");
            parola=scanner.nextLine();
            out.writeBytes(operazione + "\n");
            out.writeBytes(parola +"\n");
            parolafinale=in.readLine();
            System.out.println(parolafinale);
         }
        }while(!operazione.equals("5"));

    }
}