/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vending.ui;

import com.vending.dto.Item;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aishwarya
 */
public class VendingView {
    
    private static Scanner sc = new Scanner(System.in);

 
    
    public List<Item> loadItem() {
         Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(new File("inventory.txt"))));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VendingView.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Item> itemList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
              Item item = new Item();
            String[] words = line.split(",");

            for (String word : words) {
              
                String[] w = word.split("=");
                 if (word.contains("id")) {
                    item.setId(Integer.parseInt(w[1]));
                }
                if (word.contains("itemName")) {
                    item.setItemName(w[1]);
                }
                if (word.contains("cost")) {
                    item.setCost((new BigDecimal(w[1])));
                }
                if (word.contains("noOfInventory")) {
                    item.setNoOfInventory(Integer.parseInt(w[1]));
                }
                   
            }
            if(item.getItemName()!=null)
                itemList.add(item);
            //split string// name, id, tile, rating,
        }
        return itemList;
    }

    
    

    public String showItem(List<Item> items) {
        for(Item item : items){
            System.out.println(item);
        }
       System.out.println("Do you want to exit (Y/N) :");
        return sc.nextLine();
        
    }
    
    public BigDecimal getAmount() {
        
        System.out.println("Please enter the amount:");
        return new BigDecimal(sc.nextLine());
    }

    public int selectItem() {
        System.out.println("Select the Item Id :"); 
        return sc.nextInt();
    }

    public String options() {
        sc.nextLine();
       System.out.println("Do you want to exit (Y/N) :");
       return sc.nextLine();
    }

    public BigDecimal reEnterAmount() {
        sc.nextLine();
       System.out.println("Please enter the valid  amount:");
      return new BigDecimal(sc.nextLine());
    }
}
