package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MioThread extends Thread{
    Socket ss;
    public MioThread(Socket ss){
       this.ss=ss;
    }
    public void run(){
      
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(ss.getInputStream()));
                DataOutputStream out = new DataOutputStream(ss.getOutputStream());
                String operazione;
                String parola;
                String parolafinale;
             do{
               operazione=in.readLine();

               if(operazione.equals("5")){
                System.out.println("server terminato...");
                ss.close();
               }
               else{

                parola=in.readLine();//serve per prendere la parola dal client
               switch (operazione) {
                case "1":
                    parolafinale=parola.toUpperCase();
                    out.writeBytes(parolafinale+"\n");
                    break;
                    case "2":
                    parolafinale=parola.toLowerCase();
                    out.writeBytes(parolafinale + "\n");
                    break;
                    case "3":
                    StringBuilder inverso=new StringBuilder(parola);
                    inverso.reverse();
                    out.writeBytes(inverso+"\n");
                    break;
                    case "4":
                    parolafinale=""+parola.length();
                    out.writeBytes(parolafinale + "\n");
                    break;
                default:
                System.out.println("error");
                    break;
               }
            }
             }while(!operazione.equals("5"));
            } catch (IOException e) {
               
                e.printStackTrace();
            }
    }
}

