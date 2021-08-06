/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vending.service;

import com.vending.customException.InsufficientFundsException;
import com.vending.customException.ItemNotAvailableException;
import com.vending.customException.NoItemInventoryException;
import com.vending.dao.VendingDao;
import com.vending.dao.VendingDaoImpl;
import com.vending.dao.VendingMachineAuditDao;
import com.vending.dto.Change;
import com.vending.dto.Item;
import com.vending.util.Coins;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Aishwarya
 */
public class VendingServiceImpl implements VendingService{
    private VendingDao vendingDao;
    private List<Item> itemList;
    private VendingMachineAuditDao auditDao;
     Change change = new Change();
    private Change Change;
     
public VendingServiceImpl(VendingDao vendingDao, VendingMachineAuditDao auditDao) {
    this.vendingDao = vendingDao;
    this.auditDao = auditDao;
}


    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public Change setAmount(BigDecimal amount) {
      
       change.setAmount(amount);
       return change;
    }

    @Override
    public String checkItemInventory(int id, Change change)throws InsufficientFundsException, NoItemInventoryException, ItemNotAvailableException {
       Item item = itemList.stream().filter(itm->itm.getId()==id).findFirst().orElse(null);
       if(item!=null){
           if(item.getNoOfInventory()!=0){
           if((change.getAmount().compareTo(item.getCost())) == 0){
               //keep one more if condition to check no of inventry 
               item.setNoOfInventory(item.getNoOfInventory()-1);
               change.setAmount(change.getAmount().subtract(item.getCost()));
               this.change = change;
               int index = itemList.indexOf(item);
               itemList.set(index, item);
              String str = vendingDao.getCoinsValue(change.getAmount().multiply(new BigDecimal(100)),change);//.subtract(change.getAmount())).multiply(new BigDecimal(100)));//
               return str;
              
           }
           
          else if((change.getAmount().compareTo(item.getCost())) == 1){
               //keep one more if condition to check no of inventry 
               item.setNoOfInventory(item.getNoOfInventory()-1);
               change.setAmount(change.getAmount().subtract(item.getCost()));
               this.change = change;
               int index = itemList.indexOf(item);
               itemList.set(index, item);
                String str = vendingDao.getCoinsValue(change.getAmount().multiply(new BigDecimal(100)),change);
               return str;
              
               
           }
           else{
               throw new InsufficientFundsException("InsufficientFunds ");
           }
           }
           else{
               throw new NoItemInventoryException("Items are not available in inventory");
           }
       }else{
           throw new ItemNotAvailableException("No item available with given id");
       }
       
    }

    @Override
    public void saveToFile() {
       vendingDao.saveInFile(itemList);
    }
    
    
    
    
    
}
