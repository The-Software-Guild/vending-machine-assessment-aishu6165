/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vending.service;

import com.vending.dto.Change;
import com.vending.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Aishwarya
 */
public interface VendingService {
    public void setItemList(List<Item> itemList);

    public Change setAmount(BigDecimal amount);

    public String checkItemInventory(int id, Change change)throws Exception ;

    public void saveToFile();
    
}
