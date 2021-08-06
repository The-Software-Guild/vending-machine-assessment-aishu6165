/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vending.dao;

import com.vending.dto.Change;
import com.vending.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Aishwarya
 */
public interface VendingDao {

    public String getCoinsValue(BigDecimal cost,Change change);

    public void saveInFile(List<Item> itemList);

    
}
