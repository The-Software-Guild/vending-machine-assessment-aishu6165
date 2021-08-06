/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vending.dao;

import com.vending.dto.Change;
import com.vending.dto.Item;
import com.vending.util.Coins;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aishwarya
 */
public class VendingDaoImpl implements VendingDao{

    
    

    public VendingDaoImpl() {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    
    public String getCoinsValue(BigDecimal cost,Change change) {
            
      
        return change.getChange(cost);
    }
    @Override
    public void saveInFile(List<Item> itemList) {
         PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream("inventory.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VendingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        for (Item item : itemList)
        {
            
            pw.println(item); //
        }
        
        pw.close();
        
        System.out.println("Thank you visit again");
    

    }

   
}
