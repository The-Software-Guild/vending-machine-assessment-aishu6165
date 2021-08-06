/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vending.dao;

import java.math.BigDecimal;

/**
 *
 * @author Aishwarya
 */
public interface VendingMachineAuditDao {
     
    public void writeAuditEntry(String entry) ;

    public void writeAuditEntry(BigDecimal amount);
   
}

