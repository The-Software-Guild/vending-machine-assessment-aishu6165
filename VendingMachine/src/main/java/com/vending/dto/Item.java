/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vending.dto;

import java.math.BigDecimal;

/**
 *
 * @author Aishwarya
 */
public class Item {
    private int id;
    private String itemName;
    private BigDecimal cost;
    private int noOfInventory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getNoOfInventory() {
        return noOfInventory;
    }

    public void setNoOfInventory(int noOfInventory) {
        this.noOfInventory = noOfInventory;
    }

    @Override
    public String toString() {
        return "id=" + id + ", itemName=" + itemName + ", cost=" + cost + ", noOfInventory=" + noOfInventory ;
    }

    
    
    
}
