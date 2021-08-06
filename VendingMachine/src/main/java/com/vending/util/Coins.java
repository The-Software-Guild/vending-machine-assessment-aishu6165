/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vending.util;

import com.vending.ui.*;
import java.math.BigDecimal;

/**
 *
 * @author Aishwarya
 */
public enum Coins {
    
    QUARTERS("25"), DIMES("10"), NICKELS("5") ,PENNIES ("1") ;
     
      // declaring private variable for getting values
    private String value;
  
    // getter method
    public BigDecimal getValue()
    {
        return new BigDecimal(this.value);
    }
  
    // enum constructor - cannot be public or protected
    private Coins(String coins)
    {
        this.value = coins;
    }

    
}
