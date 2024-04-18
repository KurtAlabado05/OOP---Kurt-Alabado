/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author (-_-)(-_-)
 */
public class Database {
    File file;
     
    public Database() {
       
        file = new File("C:/Users/(-_-)(-_-)/Documents/NetBeansProjects/BankingSystem01/Data.txt"); // Specify the correct file path with extension
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Account> getAccounts() {
        String text = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while ((s = br.readLine()) != null) {
                text = text + s;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Account> accounts = new ArrayList<>();
        String[] array1 = text.split("<NewAccount/>");
        for (String v : array1) {
            if (!v.equals("")) {
                String[] array2 = v.split("<A/>");
                Account a = new Account();
                a.setName(array2[0]);
                a.setAccnum(array2[1]);
                a.setBalance(Double.parseDouble(array2[2]));
                a.setPasscode(array2[3]);
                accounts.add(a);
            }
        }
        return accounts;
    }

    public void saveAccounts(ArrayList<Account> accounts) {
        StringBuilder text = new StringBuilder();
        for (Account a : accounts) {
            text.append(a.getName()).append("<A/>");
            text.append(a.getAccnum()).append("<A/>");
            text.append(a.getBalance()).append("<A/>");
            text.append(a.getPasscode()).append("<A/>");
            text.append("<NewAccount/>\n");
        }
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            pw.print(text);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
