/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vending.service;

import com.vending.dao.VendingDao;
import com.vending.dao.VendingDaoImpl;
import com.vending.dao.VendingMachineAuditDao;
import com.vending.dao.VendingMachineAuditDaoFileImpl;
import com.vending.dto.Change;
import com.vending.dto.Item;
import com.vending.ui.VendingView;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



/**
 *
 * @author Aishwarya
 */

public class VendingServiceImplTest {
     private VendingDao vendingDao;
    private List<Item> itemList;
    private VendingService service;
    
     Change change = new Change();
     

   
   public  void setUp(){
       this.vendingDao = new VendingDaoImpl();
       VendingView view = new VendingView();
       VendingMachineAuditDao auditDao = new VendingMachineAuditDaoFileImpl();
       this.service = new VendingServiceImpl(vendingDao, auditDao);
      
       itemList = view.loadItem();
        service.setItemList(itemList);
   }
    
   @Test
    public void setItemListtest(){
        this.setUp();
        service.setItemList(itemList);
        
    }

    @Test
    public void setAmountTest() {
        this.setUp();
       Change change = service.setAmount(new BigDecimal(10));
       assertEquals(new BigDecimal(10),change.getAmount());
    }
    
    @Test
    public void saveToFileTest(){
        this.setUp();
        service.saveToFile();
    }
    
}
