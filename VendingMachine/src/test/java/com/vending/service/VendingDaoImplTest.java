/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vending.service;

import com.vending.dao.VendingDao;
import com.vending.dao.VendingDaoImpl;
import com.vending.dto.Change;
import com.vending.ui.VendingView;
import java.math.BigDecimal;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Aishwarya
 */
public class VendingDaoImplTest {
    VendingDao dao = new VendingDaoImpl();
    
    @Test
    public void getCoinsValueTest(){
        Change change = new Change();
        String str = dao.getCoinsValue(new BigDecimal(BigInteger.TEN), change);
        assertEquals(str, str);
    }
    
    @Test
    public void saveInFileTest(){
        VendingView view = new VendingView();
        
        dao.saveInFile(view.loadItem());
    }
}
