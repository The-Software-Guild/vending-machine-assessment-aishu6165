/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vending.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Aishwarya
 */

public class VendingMachineAuditDaoFileImpl implements VendingMachineAuditDao{
 
    public static final String AUDIT_FILE = "audit.txt";

  

   
    public void writeAuditEntry(String entry) {
        PrintWriter out = null;
       
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
           System.out.println("Could not persist audit information."+ e);
        }
 
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }

    @Override
    public void writeAuditEntry(BigDecimal amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}    

