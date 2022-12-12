package com.catalyte.training.monkeytesting;

import org.junit.Test;
import static org.junit.Assert.*;

public class MonkeyTest
{
    MonkeyTrouble testing = new MonkeyTrouble();
    @Test
    public void twoSmilesTest(){
        assertTrue(true == testing.monkeyTrouble(true,true));

    }// end test

    @Test
    public void twoNoSmilesTest(){
        assertTrue(true == testing.monkeyTrouble(false,false));

    }// end test


    @Test
    public void aSmilesTest(){
        boolean expectedResult = testing.monkeyTrouble(true, false);
        boolean actualResult = false;
        assertEquals(expectedResult, actualResult);
    }// end test


    @Test
    public void bSmilesTest(){
        boolean expectedResult = testing.monkeyTrouble(false, true);
        boolean actualResult = false;
        assertEquals(expectedResult, actualResult);
    }// end test

}//end class




