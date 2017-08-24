package com.company;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Portscan{
    int portmax;
    String host;
    Portscan(String x, int y){
        portmax = y;
        host = x;
        System.out.println("Settings Loaded . . .");
    }
    boolean port_available(String target, int port) {
        try (Socket x = new Socket(target, port)) {
            System.out.println("PORT" + port + " Yes");
            return false;
        } catch (IOException x) {
            System.out.println("PORT" + port + " No");
            return true;
        }
    }
    void cycle(){
        System.out.println("Cycling . . .");
        int i = 0;
        List yes = new ArrayList();
        while(i <= portmax){
            if(port_available(host, i) == false){
                yes.add(i);
            }
            i = i + 1;
        }
        System.out.println("\n\n\n\n\nPORTS OPEN:");
        for(int x = 0; x < yes.size(); x++){
            System.out.println("PORT" + yes.get(x));
        }
    }

}
public class Main {

    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println("enter hostname:");
        String hostname = x.next();
        System.out.println("enter max port (i.e. 0-(portmax)range):");
        int max = x.nextInt();
        Portscan bruh = new Portscan(hostname, max);
        bruh.cycle();
    }
}