package com.tw.pathashala.menu;

import com.tw.pathashala.constants.Constants;
import org.junit.Test;

import static com.tw.pathashala.constants.Constants.CONTINUE;
import static org.junit.Assert.*;

public class CheckOutTest {

    @Test
    public void shouldReturnContinueOnExecuteMethod() {
        CheckOut checkOut = new CheckOut();

        String actualResult = checkOut.execute();

        assertEquals(CONTINUE, actualResult);
    }

}