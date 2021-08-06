/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vending.controller;

import com.vending.customException.InsufficientFundsException;
import com.vending.customException.ItemNotAvailableException;
import com.vending.customException.NoItemInventoryException;
import com.vending.dao.VendingMachineAuditDao;
import com.vending.dao.VendingMachineAuditDaoFileImpl;
import com.vending.dto.Change;
import com.vending.dto.Item;
import com.vending.service.VendingService;
import com.vending.ui.VendingView;
import com.vending.util.Coins;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aishwarya
 */
public class VendingController {
    
    private VendingView view;
    private VendingService service;
    private VendingMachineAuditDao audit ;
    private Change change;
   
    

    public VendingController(VendingView view, VendingService service,VendingMachineAuditDao audit) {
        this.view = view;
        this.service = service;
        this.audit = audit;
    }
    
    public void run(){
      
            List<Item> itemList =  view.loadItem();
            service.setItemList(itemList);
            String str = view.showItem(itemList);
               
           if(str.equalsIgnoreCase("y")){
            System.out.println("Thank you visit again");
            System.exit(0);
             }
            BigDecimal amount = view.getAmount();
            
            saveAmount(amount);
            int id = view.selectItem();
            
           String msg = checkItemAvaibility(id);
           switch(msg){
               case "NoFund":
                    amount = amount.add(view.reEnterAmount());
                    saveAmount(amount);
                    id = view.selectItem();
                    msg = checkItemAvaibility(id);
                   break;
               case "Inventory":
                    id =  view.selectItem();
                    msg = checkItemAvaibility(id);
                   break; 
                case "NoIdFound":
                    id =  view.selectItem();
                    msg = checkItemAvaibility(id);
                   break;       
                   
           }
           
           System.out.println(msg);
       audit.writeAuditEntry(msg);
        String strMessage = view.options();
        if(strMessage.equalsIgnoreCase("y")){
            service.saveToFile();
        }
        else{
            this.run();
        }
    }

    private void saveAmount(BigDecimal amount) {
       change =  service.setAmount(amount);
       audit.writeAuditEntry(amount.toString());
      
    }

    private String checkItemAvaibility(int id) {
       String str = null;
        try {
            str = service.checkItemInventory(id,change);
        } catch (InsufficientFundsException ex) {
            System.out.println(ex.getMessage());
             audit.writeAuditEntry(ex.getMessage());
            return "NoFund";
        }
         catch (NoItemInventoryException ex) {
             System.out.println(ex.getMessage());
           return "Inventory";
        }
         catch (ItemNotAvailableException ex) {
             System.out.println(ex.getMessage());
            return "NoIdFound";
        }
         catch (Exception ex) {
             ex.printStackTrace();
           System.out.println("Something went wrong please do that again");
           this.run();
        }
        
        return str;
    }

}