package com.mycompany.chatapp_poe;

import java.util.Scanner;

public class ChatApp_POE {

    public static void main(String[] args) {
        
    Scanner input = new Scanner(System.in);
    Login login = new Login();    
    
  //Registration
    System.out.println("=== Register ===");

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter phone number: ");
        String phone = input.nextLine();

        String registerMessage = login.RegisterUser(username, password, phone);
        System.out.println(registerMessage);
    
  //Login
     System.out.println("\n=== Login ===");

        System.out.print("Enter username: ");
        String loginUser = input.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = input.nextLine();

        System.out.println(login.returnLoginStatus(loginUser, loginPassword));
      
    }
}
