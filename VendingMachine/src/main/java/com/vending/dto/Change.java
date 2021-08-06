/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vending.dto;

import com.vending.util.Coins;
import java.math.BigDecimal;

/**
 *
 * @author Aishwarya
 */
public class Change {
    BigDecimal amount;
    
    private BigDecimal quarters, remainingQters, dimes, remainingDimes,nickels, remainingNickels, pennies;
   
   
   public String getChange(BigDecimal change){
       
       String str="";
     
       quarters= change.divide(Coins.QUARTERS.getValue());
      
       remainingQters=change.remainder(Coins.QUARTERS.getValue());
     
       str += getQuarters().intValue() + " quarters ";
       
       if(remainingQters!=new BigDecimal(0)){
        
           dimes=remainingQters.divide(Coins.DIMES.getValue());
       
           remainingDimes=remainingQters.remainder(Coins.DIMES.getValue());
           str += getDimes().intValue() + " Dimes ";
       }
       
       if(remainingDimes != new BigDecimal(0)){
           nickels=remainingDimes.divide(Coins.NICKELS.getValue());
           remainingNickels=remainingDimes.remainder(Coins.NICKELS.getValue());
           str += getNickels().intValue() + " Nickels ";
           
       }
       if(remainingNickels != new BigDecimal(0)){
           pennies=remainingNickels;
             str += getPennies().intValue() + " Pennies ";
       }
       
       
     
       
       
       return str;
   }

    public BigDecimal getQuarters() {
        return quarters;
    }

    public void setQuarters(BigDecimal quarters) {
        this.quarters = quarters;
    }

    public BigDecimal getRemainingQters() {
        return remainingQters;
    }

    public void setRemainingQters(BigDecimal remainingQters) {
        this.remainingQters = remainingQters;
    }

    public BigDecimal getDimes() {
        return dimes;
    }

    public void setDimes(BigDecimal dimes) {
        this.dimes = dimes;
    }

    public BigDecimal getRemainingDimes() {
        return remainingDimes;
    }

    public void setRemainingDimes(BigDecimal remainingDimes) {
        this.remainingDimes = remainingDimes;
    }

    public BigDecimal getNickels() {
        return nickels;
    }

    public void setNickels(BigDecimal nickels) {
        this.nickels = nickels;
    }

    public BigDecimal getRemainingNickels() {
        return remainingNickels;
    }

    public void setRemainingNickels(BigDecimal remainingNickels) {
        this.remainingNickels = remainingNickels;
    }

    public BigDecimal getPennies() {
        return pennies;
    }

    public void setPennies(BigDecimal pennies) {
        this.pennies = pennies;
    }

   
  
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Change{" + "amount=" + amount + '}';
    }
    
}
