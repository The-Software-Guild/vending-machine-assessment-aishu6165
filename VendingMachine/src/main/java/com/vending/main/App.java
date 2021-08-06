/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vending.main;

import com.vending.controller.VendingController;
import com.vending.dao.VendingDao;
import com.vending.dao.VendingDaoImpl;
import com.vending.dao.VendingMachineAuditDao;
import com.vending.dao.VendingMachineAuditDaoFileImpl;
import com.vending.service.VendingService;
import com.vending.service.VendingServiceImpl;
import com.vending.ui.VendingView;

/**
 *
 * @author Aishwarya
 */
public class App {

    private static VendingMachineAuditDao auditDao;
    private static VendingService service;
    
    public static void main(String[] args){
        VendingView view = new VendingView();
        VendingDao vendingDao = new VendingDaoImpl();
         // Instantiate the Audit DAO
        VendingMachineAuditDao auditDao =  new VendingMachineAuditDaoFileImpl();
        //Instantiate the Service Layer and wire the DAO and Audit DAO into it
        VendingService service = new VendingServiceImpl(vendingDao,auditDao);
        // Instantiate the Controller and wire the Service Layer into it
        VendingController vendingController = new VendingController(view, service,auditDao);
        // Kick off the Controller
        vendingController.run();
    }
    
}

    